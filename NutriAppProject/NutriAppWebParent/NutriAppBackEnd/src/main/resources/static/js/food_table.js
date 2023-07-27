$(document).ready(function() {
	drawTable();
});

	function drawTable(url){
		if(!url){
			url = moduleURL + "get_food_list";
		}
			var table = $('#food-table').DataTable({
		       searching: false,
	  			ajax: {
	   			    "url":  url,
	   			    "type": "GET",
  			    	"dataSrc": "",
	  			    	 
	  			  },
    			rowId: function(a) {
		    		    return  a.fdcId;
		    	  },
   			  	columnDefs: [
  		            	{ 	targets: [0], 
   	   		            	data: "description",
   	   		                render: function (data) {
                            	return "<div class='text-wrap width-400'>" + data + "</div>"}},
   	   		         	{ 	targets: [1], 
   	   		            	defaultContent: '<input type="text" value="1"  size="10" onkeyup="changeGramWeight(this);">',
   	   		          		createdCell:  function (td, row) {
   	   		          			var rowId =  $(td, row).closest('tr').attr("id");
   	   		                    $(td, row).attr('id', 'amount_' + rowId); 
   	   		          		},
   	   		               	className: 'dt-body-center',
           					sortable: false },
               			{ 	targets: [2], 
		            		data: function (row) {
	   		              		if (row.foodPortions == null) {								
	   		                		return null;
	   		              		} else {									
	   		                		return buildDropdown(row.foodPortions, row.fdcId);
	   		              		}
            				},
            				className: 'dt-body-center',
            				sortable: false},
           				{ 	targets: [3],        			 			 
   			 			    data: "foodPortions[0].gramWeight",
						    render: $.fn.dataTable.render.number( ',', '.', 2, '','' ),
   			 			    createdCell:  function (td, row) {
	   		          			var rowId =  $(td, row).closest('tr').attr("id");
	   		                    $(td, row).attr('id', 'gramWeight_' + rowId); 
	   		          		},
	   		          	    className: 'dt-body-center',
   			 				sortable: false },
   			 			{
   			 				targets: [4],
   			 			    sortable: false,
   			 			    className: 'dt-body-center',
							data: function ( row ) {
	   		              		if (row.foodPortions == null) {
	   		                		return null;
	   		              		} else {
	   		                		return initCheckBox(row.foodPortions, row.fdcId);
	   		              		}
        					}
		 				}

   		         ]

   			});
	    	 function buildDropdown(data, rowId) {
	    		    var dropdown = "<select id=\"measure_" + rowId + "\" onchange=\"changeGramWeight(this);\">";
	    		    for (var i = 0; i < data.length; i++) {
	    		      var option = "<option id=\"" + data[i].sequenceNumber+ "\" value=\"" + data[i].modifier+ "\">" + data[i].modifier + "</option>";						
	    		      dropdown += option ;
	    		    }
	    		    dropdown  += "</select>";
	    		    return dropdown;
	    		  };
 			function initCheckBox(data, rowId) {
	    		    var weightData = "<input type=\"checkbox\" id=\"food_item_selected\" value= \"1\">";	    		    
	    		    for (var i = 0; i < data.length; i++) {
	    		      var item = "<input type=\"hidden\" id=\"gramWeight_"+ rowId +"_" + data[i].sequenceNumber+ "\" value=\"" + data[i].gramWeight + "\">";
	    		      weightData = weightData + item;
	    		    }	    		 
	    		    //console.log('print: ' + weightData);
	    		    return weightData;
	    		  };

    		  
	    	$.fn.dataTable.ext.errMode = function ( settings, helpPage, message ) { 
	    	    console.log(message);
	    	};
		      $('.search-btn').click(function(){
		          var keyword = $('.search-keyword').val(); 
		          table.ajax.url( moduleURL + "search_food/" + keyword ).load();
		      });

			
	}
	    
	    function changeGramWeight(data){
    	  var foodId = $(data).closest('tr').attr('id');
          console.log("foodId: "+ foodId);
		  var amount = $('#amount_' + foodId).find('input').val();
		  console.log("amount: "+ amount);
		  //var optionId = $(this).children(":selected").attr("id");
		  var sequenceNum = $('#measure_' + foodId).find('option:selected').attr('id');
		  console.log("sequenceNum: "+ sequenceNum);
		  console.log("gram: " + $('#gramWeight_' + foodId+ "_" + sequenceNum).val())
		  var newGramWeight = amount * $('#gramWeight_' + foodId+ "_" + sequenceNum).val();
		  console.log("newGramWeight: "+  newGramWeight);
		  if (!isNaN(newGramWeight)) {
	            $('#gramWeight_' + foodId)
	                    .html(
                		 newGramWeight.toFixed(2)
	            );
	            
	        } else {
	        	 $('#gramWeight_' + foodId)
	                    .html(
	                    'Invalid'
	            );
	        }

		  };
      $('search-btn').click(function(){
          var keyword = $('.search-keyword').val(); 
			console.log("url: " + moduleURL + "/" + keyword)
		  drawTable(moduleURL + "search_food/" + keyword);
          table.ajax.url( 'newData.json' ).load();
      });



		  
		 
   