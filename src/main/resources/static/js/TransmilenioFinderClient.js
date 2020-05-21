 var TransmilenioFinderClient= (function(){
    return {

        

        getAllBuses: function(callback){

            jQuery.ajax({
                url: "/TransmilenioBuses",
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Sistema no esta en linea");
                     
                } ,
                async: true
            });
        }
    };
})();
