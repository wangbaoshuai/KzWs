window.onload = initAll;
function initAll() {
	var contentList =document.getElementById("contentList");
	var first = contentList.firstChild;
	if (first.nodeType==3) {
		first = first.nextSibling;
	}
	contentList.removeChild(first);
	var msgContent = document.getElementById("msgContent");
	msgContent.onclick = function () {
		if (this.value==this.defaultValue) {
			this.value = "";
		}
	};
	var submitButton = document.getElementById("submitButton");
	submitButton.onclick = function () {
		var msgTitle = document.getElementById("msgTitle").value;
		var userName = document.getElementById("userName").value;
		if (!msgTitle || !userName || !msgContent.value) {
			alert("«ÎÃÓ–¥ÕÍ’˚ ! ! !");
		} else {
			var li = first.cloneNode(true);
			classGetter("msgTitle",li)[0].firstChild.nodeValue = msgTitle;
			classGetter("userName",li)[0].firstChild.nodeValue = userName;
			classGetter("msgDate",li)[0].firstChild.nodeValue = (new Date()).toLocaleString();
			classGetter("msgContent",li)[0].innerHTML = msgContent.value.encodeHTML().nl2br();
			contentList.appendChild(li);
		}
	};
	
	var asc = document.getElementById("sortASC");
	var desc = document.getElementById("sortDESC");
	asc.onclick = function () {
		msgSort(-1);
	};
	desc.onclick = function () {
		msgSort(1);
	};
	function msgSort(dir) {
		var list = contentList.childNodes;
		var obj;
		var d;
		var arr = [];
		var dateArr;
		var re = new RegExp();
		re.compile("^(\\d{4}).(\\d{1,2}).(\\d{1,2}).\\s(\\d{2}):(\\d{2}):(\\d{2})");
		for (var i=0;i<list.length;i++) {
			if (list[i].nodeType==3) {continue;}
			dateArr =re.exec(classGetter("msgDate",list[i])[0].firstChild.nodeValue);
			d = new Date(dateArr[1],dateArr[2]-1,dateArr[3],dateArr[4],dateArr[5],dateArr[6]);
			obj ={
				node:list[i],
				time:d.getTime()
			};
			arr.push(obj);
		}
		if (arr.length<2) {
			return false;
		}
		arr.sort(function (a,b) {
			return (a.time>b.time)?-dir:dir;
		});
		while (contentList.firstChild) {
			contentList.removeChild(contentList.firstChild);
		}
		var frag = document.createDocumentFragment();
		for (var i=0;i<arr.length;i++) {
			frag.appendChild(arr[i].node);
		}
		contentList.appendChild(frag);
	};
}
