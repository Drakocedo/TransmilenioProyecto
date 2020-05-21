  var TransmilenioFinderApp= (function(){
    document.addEventListener('DOMContentLoaded', function () {
     if (document.querySelectorAll('#map').length > 0)
     {
       if (document.querySelector('html').lang)
         lang = document.querySelector('html').lang;
       else
         lang = 'en';

       var js_file = document.createElement('script');
       js_file.type = 'text/javascript';
       js_file.src = 'https://maps.googleapis.com/maps/api/js?callback=initMap&signed_in=true&language=' + lang;
       document.getElementsByTagName('head')[0].appendChild(js_file);
     }
   });
   var map;
   var markers;
   var bounds;

   var mapeador= function(m)
   {
     markers = [];
     bounds = new google.maps.LatLngBounds();

     m.forEach(function (marker) {
       var position = new google.maps.LatLng(marker.latitud, marker.longitud);
       var image = "imagenes/icon.PNG"
	   
       markers.push(
         new google.maps.Marker({
           position: position,
           map: map,
           animation: google.maps.Animation.DROP,
           icon: image
         })
       );

       bounds.extend(position);
     });

     map.fitBounds(bounds);
   };

   var getBuses=function()
   {
       TransmilenioFinderClient.getAllBuses(mapeador)
   }
   
   
   var initMap =function()
   {
     map = new google.maps.Map(document.getElementById('map'), {
       center: {lat: 4.7495, lng: -74.0470},
       zoom: 8
     });
     getBuses();
     fetch('https://raw.githubusercontent.com/jayshields/google-maps-api-template/master/markers.json')
       .then(function(response){return response.json()})
       .then(plotMarkers);
       
   }
   return {
        initMap:initMap,
        mapeador:mapeador,
        getBuses:getBuses
   

   
}})();