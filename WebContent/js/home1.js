/*侧栏菜单选中样式*/
$(".left-nav").on("click", ".title", function() {
	var index = $(".left-nav .title").index(this);
	$(".left-nav .one-nav").eq(index).addClass("selected-one-nav");
	$(".left-nav .one-nav").eq(index).siblings(".one-nav").removeClass("selected-one-nav");
	$(".two-navs").eq(index).toggle();
	$(".two-navs").eq(index).parent().siblings(".one-nav").find(".two-navs").hide();
	$(".left-nav .jt").eq(index).toggleClass("xuanzhuan-jt")
	$(this).parent().siblings(".one-nav").find(".jt").removeClass("xuanzhuan-jt");

	var bigTit = $(".left-nav .title").eq(index).text()
	$(".big-title").text("--" + bigTit);
	$(".small-title").text("")

});

/*二级菜单选中字体变色*/
/*$(".two-navs").on("click", ".two-nav-a", function() {
	var index = $(".two-navs .two-nav-a").index(this);
	$(".two-navs .two-nav-a").removeClass("lvcolor");
	$(".two-navs .two-nav-a").eq(index).addClass("lvcolor");
	var smalTit = $(".two-navs .two-nav-a").eq(index).text()
	$(".small-title").text("--" + smalTit);

})*/