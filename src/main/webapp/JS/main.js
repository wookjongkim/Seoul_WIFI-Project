// 내 위치 가져오기 버튼 클릭 시 input들에 값이 입력되게끔 하기
document.addEventListener('DOMContentLoaded', function(){
    const getLocationBtn = document.getElementById('getLocationBtn');
    if(getLocationBtn){
        getLocationBtn.addEventListener('click', function(){
            navigator.geolocation.getCurrentPosition(function(position){
                const LAT = document.getElementById('LAT');
                const LNT = document.getElementById('LNT');
                LAT.value = position.coords.latitude.toFixed(6);
                LNT.value = position.coords.longitude.toFixed(6);
            })
        });
    }
})
// 근처 가까운 20개 와이파이 조회하기!
document.addEventListener('DOMContentLoaded', function () {
    const getWifiInfoBtn = document.getElementById('getWifiInfoBtn');
    if(getWifiInfoBtn){
        getWifiInfoBtn.addEventListener('click', function () {
            const lat = parseFloat(document.getElementById('LAT').value);
            const lon = parseFloat(document.getElementById('LNT').value);

            saveHistory(lat,lon); // 히스토리 정보 저장

            // 비동기 통신 부분
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
    }
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
            wifiInfoList[i].distanceKm.toFixed(4), wifiInfoList[i].manageNum,
            wifiInfoList[i].district, wifiInfoList[i].wifiName, wifiInfoList[i].roadAddress,
            wifiInfoList[i].detailAddress, wifiInfoList[i].installationFloor, wifiInfoList[i].installationType,
            wifiInfoList[i].installationAgency, wifiInfoList[i].serviceType, wifiInfoList[i].networkType,
            wifiInfoList[i].installationYear, wifiInfoList[i].indoorOutdoor, wifiInfoList[i].wifiConnectionEnvironment,
            wifiInfoList[i].xCoordinate, wifiInfoList[i].yCoordinate, wifiInfoList[i].operationDate
        ];
        rowData[3] = '<a href="detail.jsp?manageNum=' + wifiInfoList[i].manageNum + '">' + wifiInfoList[i].wifiName + '</a>';

        for (let j = 0; j < rowData.length; j++) {
            let cell = row.insertCell(j);
            cell.innerHTML = rowData[j];
        }
    }
}

function saveHistory(lat, lon){
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "saveHistory", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("xCoordinate=" + lat + "&yCoordinate=" + lon);
}

function displayHistory(){
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "getHistory", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            const historyList = JSON.parse(xhr.responseText);
            const table = document.getElementById("wifiHistoryTable");

            for(let i = table.rows.length-1; i > 0 ; i--){
                table.deleteRow(i);
            }

            if (historyList.length > 0) { // 히스토리가 있는 경우
                for(let i = 0; i < historyList.length; i++){
                    let row = table.insertRow(i+1);

                    let rowData = [
                        historyList[i].id, historyList[i].xCoordinate,
                        historyList[i].yCoordinate, historyList[i].inquiryDate,
                        '<button onclick="deleteHistory(' + historyList[i].id + ')">삭제</button>'
                    ];

                    for(let j = 0; j < rowData.length; j++){
                        let cell = row.insertCell(j);
                        cell.innerHTML = rowData[j];
                    }
                }
            }

            // 기본 문구 표시 여부 확인
            let defaultRow = table.querySelector(".default_comment_row");
            if (historyList.length === 0 && !defaultRow) { // 히스토리가 없는 경우
                let row = table.insertRow(1);
                row.classList.add("default_comment_row");

                let cell = row.insertCell(0);
                cell.colSpan = 5;
                cell.classList.add("default_comment");
                cell.innerHTML = "위치 정보를 바탕으로 조회 후 히스토리를 조회해주세요.";
            } else if (historyList.length > 0 && defaultRow) { // 히스토리가 있는 경우 기본 문구 삭제
                table.deleteRow(defaultRow.rowIndex);
            }
        }
    };
    xhr.send();
}

function deleteHistory(id){
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "deleteHistory", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            displayHistory();
        }
    };
    xhr.send("id=" + id);
}

document.addEventListener('DOMContentLoaded', function(){
    const params = new URLSearchParams(window.location.search);
    const manageNum = params.get('manageNum')
    if(manageNum){
        loadWifiDetails(manageNum);
    }
})

function loadWifiDetails(manageNum){
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "get-wifi-detail?manageNum="+manageNum,true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log(xhr.responseText);
            const wifiDetails = JSON.parse(xhr.responseText);
            displayWifiDetails(wifiDetails);
        }
    };
    xhr.send();
}

function displayWifiDetails(wifiDetails){
    for(const key in wifiDetails){
        if(wifiDetails.hasOwnProperty(key)){
            const value = wifiDetails[key];
            const valueCell = document.getElementById(key);
            if(valueCell){
                valueCell.innerText = value;
            }
        }
    }
}
function navigateAddBookMark(){
    window.location.href = 'bookmark-group-add.jsp';
}

function submitForm(){
    const bookmarkName = document.getElementById("bookmark_name").value;
    const groupOrder = document.getElementById("groupOrder").value;

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/add-bookmark-group", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            alert(xhr.responseText);
            window.location.href = "/bookmark-group.jsp";
        }
    };
    xhr.send("bookmark_name=" + encodeURIComponent(bookmarkName) + "&group_order=" + encodeURIComponent(groupOrder));
}
function displayBookmark(){
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "getBookmark", true);
    xhr.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            const bookmarkList = JSON.parse(xhr.responseText);
            const table = document.getElementById("wifiBookmarkTable");

            for(let i = table.rows.length-1; i > 0; i--){
                table.deleteRow(i);
            }

            if(bookmarkList.length > 0){
                for(let i = 0; i < bookmarkList.length; i++){
                    let row = table.insertRow(i+1);

                    let rowData = [
                        bookmarkList[i].id, bookmarkList[i].bookmark_name,
                        bookmarkList[i].groupOrder, bookmarkList[i].register_date,
                        (bookmarkList[i].modified_date === undefined ? '' : bookmarkList[i].modified_date),
                        "<a href = 'bookmark-group-edit.jsp?id="+bookmarkList[i].id+"'>수정</a>  |  "
                        + "<a href = 'bookmark-group-delete.jsp?id="+bookmarkList[i].id+"'>삭제</a>"
                    ];

                    for(let j = 0; j < rowData.length; j++){
                        let cell = row.insertCell(j);
                        cell.innerHTML = rowData[j];
                    }
                }
            }

            let defaultRow = table.querySelector(".default_comment_row");
            if(bookmarkList.length === 0 && !defaultRow){
                let row = table.insertRow(1);
                row.classList.add("default_comment_row");

                let cell = row.insertCell(0);
                cell.colSpan = 6;
                cell.classList.add("default_comment");
                cell.innerHTML = "북마크 그룹 추가 후 조회해주세요";
            }else if(bookmarkList.length >0 && defaultRow){
                table.deleteRow(defaultRow.rowIndex);
            }
        }
    };
    xhr.send();
}

function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}
function fillDefault() {
    const id = getParameterByName('id');
    if (id) {
        const xhr = new XMLHttpRequest();
        xhr.open('GET', `/getBookmarkById?id=${id}`, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const bookmark = JSON.parse(xhr.responseText);
                document.querySelector('input[type="TEXT"]').value = bookmark.bookmark_name;
                document.querySelector('input[type="number"]').value = bookmark.groupOrder;
            }
        };
        xhr.send();
    }
}
function updateBookmark() {
    const bookmarkNameInput = document.querySelector('input[type="TEXT"]');
    const groupOrderInput = document.querySelector('input[type="number"]');
    const id = new URL(window.location.href).searchParams.get("id");

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "updateBookmark", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            alert(xhr.responseText);
            window.location.href = "/bookmark-group.jsp";
        }
    };
    xhr.send(`id=${id}&bookmark_name=${encodeURIComponent(bookmarkNameInput.value)}&group_order=${groupOrderInput.value}`);
}
function deleteBookmark(){
    const id = new URL(window.location.href).searchParams.get("id");

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "deleteBookmark", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            alert(xhr.responseText);
            window.location.href = "/bookmark-group.jsp";
        }
    };
    xhr.send(`id=${id}`);
}
function loadBookmarkNames(){
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === XMLHttpRequest.DONE){
            if(xhr.status === 200){
                const bookmarkNames = JSON.parse(xhr.responseText);
                const selectElement = document.querySelector("select");

                bookmarkNames.forEach((bookmarkName) => {
                    const option = document.createElement("option");
                    option.textContent = bookmarkName;
                    option.value = bookmarkName;
                    selectElement.appendChild(option);
                });
            }
        }
    };
    xhr.open("GET", "/getBookmarkNameList", true);
    xhr.send();
}
function addFavorite(){
    const bookmarkGroup = document.querySelector("select");
    const bookmarkName = bookmarkGroup.value;
    const manageNum = new URL(window.location.href).searchParams.get("manageNum");

    if (!bookmarkName || bookmarkName === "북마크 그룹 이름 선택") {
        alert("북마크 그룹을 선택해주세요.");
        return;
    }

    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === XMLHttpRequest.DONE){
            if(xhr.status == 200){
                alert("북마크 정보를 추가하였습니다.");
                window.location.href = "/bookmark-list.jsp";
            }else{
                alert("북마크 정보 추가 에러");
            }
        }
    };
    xhr.open("POST", "/addFavorite", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(`bookmarkName=${bookmarkName}&manageNum=${manageNum}`);
}

document.addEventListener("DOMContentLoaded", function(){
    fetchFavorites();
})

function fetchFavorites(){
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                displayFavorites(JSON.parse(xhr.responseText));
            } else {
                alert("즐겨찾기 정보를 가져오는데 실패했습니다.");
            }
        }
    };
    xhr.open("GET", "/getFavorites", true);
    xhr.send();
}

function displayFavorites(favorites) {
    const table = document.getElementById("wifiFavoriteTable");
    const defaultCommentRow = table.querySelector(".default_comment").parentElement;

    if (favorites.length === 0) {
        defaultCommentRow.style.display = "table-row";
    } else {
        defaultCommentRow.style.display = "none";

        for (const favorite of favorites) {
            const row = table.insertRow(-1);
            row.insertCell(0).innerText = favorite.id;
            row.insertCell(1).innerText = favorite.bookmark_name;
            row.insertCell(2).innerText = favorite.wifiName;
            row.insertCell(3).innerText = favorite.register_date;

            const deleteButton = document.createElement("button");
            deleteButton.innerText = "삭제";
            deleteButton.addEventListener("click", function() {
                if(confirm("정말로 이 북마크를 삭제하시겠습니까?")){
                    deleteFavorite(favorite.id, row); // 삭제 기능 호출
                }
            });
            row.insertCell(4).appendChild(deleteButton);
        }
    }
}

function deleteFavorite(favoriteId, row) {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                row.remove(); // 삭제 성공 시, 해당 행을 삭제합니다.
            } else {
                alert("즐겨찾기 삭제에 실패했습니다.");
            }
        }
    };
    xhr.open("POST", "/deleteFavorite", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(`favoriteId=${favoriteId}`);
}



