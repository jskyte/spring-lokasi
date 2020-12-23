var tableProvinsi = {
	create: function(){
	
		$.ajax({
				url:'/provinsi/get-all-active',
				method:'get',
				contentType:'application/json',
				success:function(res, status, xhr) {
					data = "";
					$.each(res, function(index, value){
						data += "<tr>";
						data += "<td>" + value.id + "</td>";
						data += "<td>" + value.kodeProvinsi + "</td>";
						data += "<td>" + value.namaProvinsi + "</td>";
						data += "</tr>";
					});
					$('#body-provinsi').append(data);
					console.log(res)
				},
				error : function(e) {
					alert(e);
					console.log(e);
				}
			})
        },
        
    getProvinsi: function(){
		$.ajax({
            url: '/provinsi/get-all-active',
            type: 'get',
            contentType: 'application/json',
            success: function(res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    $('#table-provinsi').DataTable({
                        data: res,
                        columns: [{
                            title: "id",
                            data: "id"
                        }, {
                            title: "Kode Provinsi",
                            data: "kodeProvinsi"
                        }, {
                            title: "Nama Provinsi",
                            data: "namaProvinsi"
                        }, {
                            title: "Action",
                            data: null,
                            render: function(data, type, row) {
                                console.log(data)
                                return "<button class='btn-primary' onclick=formProvinsi.setEditData('" + data.id + "')>Edit</button> | <button class='btn-danger' onclick=formProvinsi.deleteData('" + data.id + "')>Delete</button>"
                            }
                        }]
                    });

                } else {}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}    
}


var formProvinsi = {
	save : function () {
		var provinsi = {}
	    provinsi["kodeProvinsi"] = $('#kodeProvinsi').val();
	    provinsi["namaProvinsi"] = $('#namaProvinsi').val();
	
	    $.ajax({
	        method:'post',
	        url:'/provinsi/add-provinsi',
	        contentType:'application/json',
	        data: JSON.stringify(provinsi),
	        success: function(res) {
	            console.log(res)
	        }
	    })	
	},
	
	setEditData: function(id) {
		$.ajax({
            method: 'get',
            url: '/provinsi/get-by-id/' + id,
            success: function(res) {
                console.log(res)
                $('#kodeProvinsi').val(res.kodeProvinsi)
                $('#namaProvinsi').val(res.namaProvinsi)
                
                $('#btn-save').off('click').on('click', function() {
               		formProvinsi.update(res.id);
                	tableProvinsi.getProvinsi;
						$('#btn-save').off('click').on('click', function(){
							formProvinsi.save();
						})
                })
            }
        })
	},
	
	update : function(id) {
		var provinsi = {}
	    provinsi["kodeProvinsi"] = $('#kodeProvinsi').val();
	    provinsi["namaProvinsi"] = $('#namaProvinsi').val();
	
	    $.ajax({
	        method:'put',
	        url:'/provinsi/update-provinsi/' + id ,
	        contentType:'application/json',
	        data: JSON.stringify(provinsi),
	        success: function(res) {
	            console.log(res)
	        }
	    })	
	},
	
	deleteData : function(id) {
		var provinsi = {}
		if(confirm("Are you sure?")) {
			$.ajax({
	        method:'put',
	        url:'/provinsi/delete-provinsi-status/' + id ,
	        contentType:'application/json',
	        data: JSON.stringify(provinsi),
	        success: function(res) {
				location.reload();
	            console.log(res)
	        }
	    })	
		} else {
			console.log("Cancel delete")
		}
	    
	}
	
}

var tableKabupaten = {
	create: function(){
	
		$.ajax({
				url:'/kabupaten/get-all-active',
				method:'get',
				contentType:'application/json',
				success:function(res, status, xhr) {
					data = "";
					$.each(res, function(index, value){
						data += "<tr>";
						data += "<td>" + value.id + "</td>";
						data += "<td>" + value.kodeKabupaten + "</td>";
						data += "<td>" + value.namaKabupaten + "</td>";
						data += "<td>" + value.provinsiEntity.namaProvinsi + "</td>";
						data += "</tr>";
					});
					$('#body-kabupaten').append(data);
					console.log(res)
				},
				error : function(e) {
					alert(e);
					console.log(e);
				}
			})
	
	},
	
	getKabupaten: function(){
		$.ajax({
            url: '/kabupaten/get-all-active',
            type: 'get',
            contentType: 'application/json',
            success: function(res, status, xhr) {
                if (xhr.status == 200 || xhr.status == 201) {
                    $('#table-kabupaten').DataTable({
                        data: res,
                        columns: [{
                            title: "id",
                            data: "id"
                        }, {
                            title: "Kode Kabupaten",
                            data: "kodeKabupaten"
                        }, {
                            title: "Nama Kabupaten",
                            data: "namaKabupaten"
                        }, {
							title: "Kode Provinsi",
							data: "provinsiEntity.namaProvinsi"
						}, {
                            title: "Action",
                            data: null,
                            render: function(data, type, row) {
                                console.log(data)
                                return "<button class='btn-primary' onclick=formKabupaten.setEditData('" + data.id + "')>Edit</button> | <button class='btn-danger' onclick=formKabupaten.deleteData('" + data.id + "')>Delete</button>"
                            }
                        }]
                    });

                } else {}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}
}


var formKabupaten = {
	save : function () {
		var kabupaten = {}
	    kabupaten["kodeKabupaten"] = $('#kodeKabupaten').val();
	    kabupaten["namaKabupaten"] = $('#namaKabupaten').val();
	    kabupaten["kodeProvinsi"] = $('#kodeProvinsiDrop').val();
	
	    $.ajax({
	        method:'post',
	        url:'/kabupaten/add-kabupaten',
	        contentType:'application/json',
	        data: JSON.stringify(kabupaten),
	        success: function(res) {
	            console.log(res)
	        }
	    })	
	}, 
	
	setEditData: function(id) {
		$.ajax({
            method: 'get',
            url: '/kabupaten/get-by-id/' + id,
            success: function(res) {
                console.log(res)
                $('#kodeKabupaten').val(res.kodeKabupaten)
                $('#namaKabupaten').val(res.namaKabupaten)
				$('#kodeProvinsiDrop').val(res.provinsiEntity.kodeProvinsi)
                
                $('#btn-save').off('click').on('click', function() {
               		formProvinsi.update(res.id);
                	tableProvinsi.getProvinsi;
						$('#btn-save').off('click').on('click', function(){
							formProvinsi.save();
						})
                })
            }
        })
	}
}

var dropDownKabupaten = {
	drop : function() {
		$(document).ready(function () {  
	        $.ajax({  
	            type: "GET",  
	            url: "/provinsi/get-all",  
	            data: "",  
	            success: function (data) {  
	                var s = '<option value="-1">Pilih Provinsi</option>';  
	                for (var i = 0; i < data.length; i++) {  
	                    s += '<option value="' + data[i].kodeProvinsi + '">' + data[i].namaProvinsi + '</option>';  
	                }  
	                $("#kodeProvinsiDrop").html(s);  
	            }  
	        });  
	    })  
	}
}

var tableKecamatan = {
	create: function(){
	
		$.ajax({
				url:'/kecamatan/get-all-active',
				method:'get',
				contentType:'application/json',
				success:function(res, status, xhr) {
					data = "";
					$.each(res, function(index, value){
						data += "<tr>";
						data += "<td>" + value.id + "</td>";
						data += "<td>" + value.kodeKecamatan + "</td>";
						data += "<td>" + value.namaKecamatan + "</td>";
						data += "<td>" + value.kabupatenEntity.namaKabupaten + "</td>";
						data += "<td>" + value.provinsiEntity.namaProvinsi + "</td>";
						data += "</tr>";
					});
					$('#body-kecamatan').append(data);
					console.log(res)
				},
				error : function(e) {
					alert(e);
					console.log(e);
				}
			})
	
	}
}

var tableDesa = {
	create: function(){
	
		$.ajax({
				url:'/desa/get-all-active',
				method:'get',
				contentType:'application/json',
				success:function(res, status, xhr) {
					data = "";
					$.each(res, function(index, value){
						data += "<tr>";
						data += "<td>" + value.id + "</td>";
						data += "<td>" + value.kodeDesa + "</td>";
						data += "<td>" + value.namaDesa + "</td>";
						data += "<td>" + value.kecamatanEntity.namaKecamatan + "</td>";
						data += "<td>" + value.kabupatenEntity.namaKabupaten + "</td>";
						data += "<td>" + value.provinsiEntity.namaProvinsi + "</td>";
						data += "</tr>";
					});
					$('#body-desa').append(data);
					console.log(res)
				},
				error : function(e) {
					alert(e);
					console.log(e);
				}
			})
	
	}
}