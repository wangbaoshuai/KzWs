//ltrim 去除字符串左边的空格
((String.prototype.ltrim = function () {return this.replace(arguments.callee.re,"");}).re = new RegExp()).compile("^\\s+","gi");
//rtrim 去除字符串右边的空格
((String.prototype.rtrim = function () {return this.replace(arguments.callee.re,"");}).re = new RegExp()).compile("\\s+$","gi");
//frim 去除字符串中所有的空格
((String.prototype.ftrim = function () {return this.replace(arguments.callee.re,"");}).re = new RegExp()).compile("\\s","gi");
//trim 去除字符串两边的空格
String.prototype.trim = function () {return this.ltrim().rtrim();};
//repeat 重复一个字符串，num参数指定重复次数
String.prototype.repeat = function (num) {return (new Array(num+1)).join(this);};
//isEmail 判断字符串是否是有效的邮箱地址，返回true表示正确
((String.prototype.isEmail = function () {return arguments.callee.re.test(this);}).re=new RegExp()).compile("^\\w{1,15}(?:@(?!-))(?:(?:[a-z0-9-]*)(?:[a-z0-9](?!-))(?:\\.(?!-)))+[a-z]{2,4}$","i");
//reverse 将字符串反转
String.prototype.reverse = function () {return this.split("").reverse().join("");};
//nl2br 将字符串中的换行符替换成<br />
((String.prototype.nl2br = function () {return this.replace(arguments.callee.re,"<br />");}).re=new RegExp()).compile("\\r\\n|\\n\\r|\\n|\\r","g");
//encodeHTML 将字符串中的HTML特殊字符替换成实体引用
String.prototype.encodeHTML = function () {
	return this.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;").replace("\"","&quote;");
};
//hasClass 测试某DOM对象是否具有某className
function hasClass(cn,obj) {
	var re = new RegExp("\\b"+cn+"\\b");
	return re.test(obj.className);
}
//classGetter 获取root元素中具有某class的元素
function classGetter(cn,root) {
	root = root || document;
	if (root.getElementsByClassName && root.getElementsByClassName.constructor == Function) {
		return root.getElementsByClassName(cn);
	}
	var allTags = root.getElementsByTagName("*");
	var reArr = [];
	for (var i=0;i< allTags.length;i++) {
		if (hasClass(cn,allTags[i])) {
			reArr.push(allTags[i]);
		}
	}
	return reArr;
}
function nextElement(node) {
	var nextNode = node.nextSibling;
	if (!nextNode) {
		return null;
	}
	if (nextNode.nodeType!=1) {
		return nextNode.nextSibling?nextNode.nextSibling:null;
	}
}