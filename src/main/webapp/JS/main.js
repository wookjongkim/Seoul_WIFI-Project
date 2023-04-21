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
// 근처 가까운 20개 와이파이 조회하기!
document.addEventListener('DOMContentLoaded', function () {
    const getWifiInfoBtn = document.getElementById('getWifiInfoBtn');

    getWifiInfoBtn.addEventListener('click', function () {
        const lat = parseFloat(document.getElementById('LAT').value);
        const lon = parseFloat(document.getElementById('LNT').value);

        const xhr = new XMLHttpRequest();
        xhr.open("GET", "get-nearby-wifi?lat="+lat+"&lon="+lon, true);
        xhr.setRequestHeader("Content-type", "application/json;charset=UTF-8");
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4 && xhr.status == 200){
                const wifiInfoList = JSON.parse(xhr.responseText);
                displayNearbyWifiInfo(wifiInfoList);
            }
        };
        xhr.send();
    });
});

function displayNearbyWifiInfo(wifiInfoList){
    const table = document.getElementById("wifiInfoTable");
    // 기존 행 삭제
    for(let i = table.rows.length-1; i > 0; i--){
        table.deleteRow(i);
    }
    // 헤더 행 제외한 데이터 행 추가
    for(let i = 0; i < wifiInfoList.length; i++){
        let row = table.insertRow(i+1);
        let rowData = [
            wifiInfoList[i].distanceKm.toFixed(4),
            wifiInfoList[i].manageNum,
            wifiInfoList[i].district,
            wifiInfoList[i].wifiName,
            wifiInfoList[i].roadAddress,
            wifiInfoList[i].detailAddress,
            wifiInfoList[i].installationFloor,
            wifiInfoList[i].installationType,
            wifiInfoList[i].installationAgency,
            wifiInfoList[i].serviceType,
            wifiInfoList[i].networkType,
            wifiInfoList[i].installationYear,
            wifiInfoList[i].indoorOutdoor,
            wifiInfoList[i].wifiConnectionEnvironment,
            wifiInfoList[i].xCoordinate,
            wifiInfoList[i].yCoordinate,
            wifiInfoList[i].operationDate
        ];
        rowData[3] = '<a href="detail.jsp?manageNum=' + wifiInfoList[i].manageNum + '">' + wifiInfoList[i].wifiName + '</a>';

        for (let j = 0; j < rowData.length; j++) {
            let cell = row.insertCell(j);
            cell.innerHTML = rowData[j];
        }
    }
}
