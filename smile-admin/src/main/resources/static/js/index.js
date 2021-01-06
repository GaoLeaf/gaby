
$(function () {

    //
    $('#side-menu').metisMenu();
    
    // 固定菜单栏 - 滚动条
    $('.sidebar-collapse').slimScroll({
    	height: '100%',
    	railOpacity: 0.9,
    	alwaysVisible: false
    });

    // 绑定菜单点击事件
    $("a.menuItem").on('click', menuItem);
    
    // 通过遍历给菜单加上data_index属性
    $(".menuItem").each(function(i){
    	if(!$(this).attr("data_index")) {
    		$(this).attr("data_index", i);
    	}
    });
    
    // 选中选项卡
    $(".menuTabs").on("click", ".menuTab", activeTab);
    
    // 关闭选项卡
    $(".menuTabs").on("click", ".menuTab i", closeTab);
    
});

function menuItem() {
	
	// 获取菜单属性
	var menuUrl = $(this).attr("href");
	var menuName = $(this).text();
	var menuDataIndex = $(this).attr("data_index");
	
	// 选项卡菜单是否存在标识
	var menuTabExisitFlag = true;
	
	// 选项卡菜单已存在
	$(".menuTab").each(function(){
		
		// 如果当前菜单已在选项卡中
		if ($(this).data("id") == menuUrl) {
			
			// 如果当前菜单未选中
			if (!$(this).hasClass("active")) {
				$(this).addClass("active").siblings(".menuTab").removeClass("active");
				scrollToTab(this);
				
				// 展示内容
				$(".mainContent .leaf_iframe").each(function(){
					if ($(this).data("id") == menuUrl) {
						$(this).show().siblings(".leaf_iframe").hide();
					}
				});
			}
			// 当前菜单已展示
			menuTabExisitFlag = false;
			
		}
		
	});
	
	// 选项卡菜单不存在
	if (menuTabExisitFlag) {
		
		// iframe
		var iframeStr = "<iframe class='leaf_iframe' name='iframe0' width='100%' height='100%' data-id='"+menuUrl+"' src='"+menuUrl+"' frameborder='0' seamless></iframe>";
		
		$("#content-main").find("iframe.leaf_iframe").hide().parents("#content-main").append(iframeStr);
		
		// 选项卡
		$(".menuTab").removeClass("active"); // 移除选项卡样式
		var menuTabStr =  '<a href="javascript:;" class="active menuTab" data-id="' + menuUrl + '">' + menuName + ' <i class="fa fa-times-circle"></i></a>';
		$(".menuTabs .page-tabs-content").append(menuTabStr);
		scrollToTab($('.menuTab.active'));
	}
	
	return false;
	
}

// 滚动到指定选项卡
function scrollToTab(element) {
	
	// 计算当前元素所有前后同辈元素的宽度
	var marginLeftVal = calSumWidth($(element).prevAll());
	var marginRightVal = calSumWidth($(element).nextAll());
	
	// 可视区域非tab宽度
	var tabOuterWidth = calSumWidth($(".content-tabs").children().not(".menuTabs"));
	
	// 可视区域tab宽度
	var visibleWidth = $(".content-tabs").outerWidth(true) - tabOuterWidth;
	
	// 实际滚动宽度
	var scrollVal = 0;
	
	// 如果菜单导航栏宽度小于可视区宽度，无需加滚动条
	if ($(".page-tabs-content").outerWidth() < visibleWidth) {
		scrollVal = 0;
	} else if (marginRightVal <= (visibleWidth - $(element).outerWidth(true) - $(element).next().outerWidth(true))) {
		if ((visibleWidth - $(element).next().outerWidth(true)) > marginRightVal) {
			scrollVal = marginLeftVal;
            var tabElement = element;
            while ((scrollVal - $(tabElement).outerWidth()) > ($(".page-tabs-content").outerWidth() - visibleWidth)) {
                scrollVal -= $(tabElement).prev().outerWidth();
                tabElement = $(tabElement).prev();
            }
		}
	} else if (marginLeftVal > (visibleWidth - $(element).outerWidth(true) - $(element).prev().outerWidth(true))) {
		scrollVal = marginLeftVal - $(element).prev().outerWidth(true);
	}
	
	$('.page-tabs-content').animate({
        marginLeft: 0 - scrollVal + 'px'
    },
    "fast");
	
}

// 计算所有元素的总宽度
function calSumWidth(elements) {
	
	var width = 0;
	
	$(elements).each(function(){
		width += $(this).outerWidth(true);
	});
	
	return width;
	
}

// 选项卡点击事件
function activeTab() {
	
	// 当前选项卡未选中
	if (!$(this).hasClass("active")) {
		
		// 展示选项卡内容
		var currentId = $(this).data("id");
		$(".mainContent .leaf_iframe").each(function(){
			if ($(this).data("id") == currentId) {
				$(this).show().siblings(".leaf_iframe").hide();
				return false;
			}
		});
		
		// 更改选中选项卡样式
		$(this).addClass("active").siblings(".menuTab").removeClass("active");
		scrollToTab(this);
	}
	
}

// 关闭选项卡
function closeTab() {
	
	// 获取需要关闭的选项卡
	var closeTab = $(this).parents('.menuTab');
	var closeTabId = closeTab.data('id');
	
	// 如果当前选项卡处于活动状态
	if (closeTab.hasClass("active")) {
		
		// 当前选项卡后还有选项卡，使后面的选项卡处于活动状态
		if (closeTab.next(".menuTab").size()) {
			
			// 获取后面第一个选项卡，更改选中样式，并展示内容
			var afterActiveTab = closeTab.next(".menuTab:eq(0)");
			
			afterActiveTab.addClass("active");
			
			$(".mainContent .leaf_iframe").each(function(){
				if ($(this).data("id") == afterActiveTab.data("id")) {
					$(this).show().siblings(".leaf_iframe").hide();
					return false;
				}
			});
			
		} else 
		// 当前选项卡后没有选项卡，使前面的选项卡处于活动状态
		if (closeTab.prev('.menuTab').size()) {
			
			// 获取前面最后一个选项卡，更改选中样式，并展示内容
			var beforeActiveTab = closeTab.prev(".menuTab:last");
			
			beforeActiveTab.addClass("active");
			
			$(".mainContent .leaf_iframe").each(function(){
				if ($(this).data("id") == beforeActiveTab.data("id")) {
					$(this).show().siblings(".leaf_iframe").hide();
					return false;
				}
			});
			
		}
		
	} 
		
	// 移除选项卡
	closeTab.remove();
	
	// 移除选项卡对应内容
	$(".mainContent .leaf_iframe").each(function(){
		if ($(this).data("id") == closeTabId) {
			$(this).remove();
			return false;
		}
	});
	
	scrollToTab($('.menuTab.active'));
	
}