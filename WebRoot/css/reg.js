window.onload = initAll;
function initAll() {
	document.body.oncontextmenu = function () {
		return false;
	};
	var regFm = document.getElementById("regForm");
	var field = regFm.getElementsByTagName("fieldset")[0];
	var agree = regFm.agreeClause;
	agree.checked = false;
	agree.onclick = function () {
		if (this.checked) {
			document.getElementById("clause").style.display="none";
			field.style.display="block";
			regFm.onsubmit = checkForm;
			var other = document.getElementById("other");
			var otherLabel =document.getElementById("otherHobbyLabel");
			other.checked =false;
			other.onclick = function () {
				if (other.checked) {
					otherLabel.style.display="block";
				} else {
					otherLabel.style.display="none";
				}
			};
			otherLabel.style.display="none";
			createSelect();
			initNotice();
		}
	};
	field.style.display="none";
	var correct = document.createElement("span");
	correct.className = "correct";
	correct.appendChild(document.createTextNode("Correct"));
	
}
function createSelect() {
	var monthArr = [0,31,28,31,30,31,30,31,31,30,31,30,31];
	var regFm = document.getElementById("regForm");
	var birthYear =regFm.birthYear;
	var birthMonth =regFm.birthMonth;
	var birthDay =regFm.birthDay;
	birthDay.options.length =birthMonth.options.length =birthYear.options.length =1;
	makeOptions(1980,2000,birthYear);
	birthYear.onchange = function () {
		birthMonth.options.length=1;
		if (!this.value) {
			return true;
		}
		birthDay.options.length=1;
		makeOptions(1,12,birthMonth);
	};
	birthMonth.onchange = function () {
		birthDay.options.length=1;
		if (!this.value) {
			return true;
		}
		month = parseInt(this.value);
		
		if (month==2) {
			monthArr[month] = (parseInt(birthYear.value) % 4)?29:28;
		}
		makeOptions(1,monthArr[month],birthDay);
	};
	
	
	function makeOptions(start,finish,sel) {
		var opt;
		for (var i=start;i<=finish;i++) {
			opt = new Option(i,i);
			sel.options[sel.options.length]= opt;
		}
	}
}
function checkForm() {
	return this._userName() && this._userPwd() && this._rePwd() && this._qq() && this._email();
}
function initNotice() {
	var regFm = document.getElementById("regForm");
	regFm._userName = function() {
		var len = this.userName.value.length;
		if (len <  2 || len > 16) {
			return false;
		}
	};
	regFm._userPwd =function() {
		var len = this.userPwd.value.length;
		if (len < 6 || len > 25) {
			return false;
		}
	};
	regFm._rePwd =function() {
		var val = this.rePwd.value;
		if (val != this.userPwd.value || val.length < 6) {
			return false;
		}
	};
	regFm._qq =function() {
		return /^\d{5,10}$/.test(this.qq.value)
	};
	regFm._email =function() {
		return this.email.value.isEmail();
	};
	var eles = regFm.elements;
	var notice;
	var wrong;
	var correctNode=document.createElement("span");
	correctNode.className="correct";
	for (var i=0;i<eles.length;i++) {
		if (eles[i].tagName!= "INPUT") {
			continue;
		}
		notice = classGetter("notice",eles[i].parentNode)[0];
		if (!notice) {
			continue;
		}
		(eles[i].notice = notice).style.display="none";
		(eles[i].correct = eles[i].parentNode.insertBefore(correctNode.cloneNode(true), eles[i].nextSibling)).style.display="none";
		eles[i].onfocus = showNotice;
		eles[i].onblur = hideNotice;
		wrong = classGetter("wrong",eles[i].parentNode)[0];
		if (wrong) {
			eles[i].wrong=wrong;
		}
	}
	function showNotice() {
		this.notice.style.display ="";
	}
	function hideNotice() {
		this.notice.style.display="none";
		if (regFm["_"+this.name]()===false) {
			this.wrong.style.display = "inline-block";
		} else {
			this.wrong.style.display = "none";
			this.correct.style.display="";
		}
		
	}
	
	var motto = regFm.motto;
	var parentNode= motto.parentNode;
	var maxLen = classGetter("maxLen",parentNode)[0];//最大字符数
	var curLen = classGetter("curLen",parentNode)[0];//当前输入的字符数
	var leftLen = classGetter("leftLen",parentNode)[0];//还可以输入的字符数
	motto.onkeyup= function () {
		maxLength = parseInt(maxLen.firstChild.nodeValue);
		this.value = this.value.substr(0,maxLength);
		var len = this.value.length;
		curLen.firstChild.nodeValue = len;
		leftLen.firstChild.nodeValue = maxLength-len;
	};
}
