// 내 위치 가져오기 버튼 클릭 시 input들에 값이 입력되게끔 하기
document.addEventListener('DOMContentLoaded', function(){
    const getLocationBtn = document.getElementById('getLocationBtn');
    getLocationBtn.addEventListener('click', function(){
        navigator.geolocation.getCurrentPosition(function(position){
            const LAT = document.getElementById('LAT');
            const LNT = document.getElementById('LNT');
            LAT.value = position.coords.latitude.toFixed(6);
            LNT.value = position.coords.longitude.toFixed(6);
        })
    })
})