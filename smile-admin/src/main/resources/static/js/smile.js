/**
 * 通用js方法封装
 */
(function ($) {

    // 扩展jquery
    $.extend({

        // 表格封装处理
        table: {
            _options: {},
            _params: {},
            init: function (options) {
                $.table._options = options;
                $("#bootstrap-table").bootstrapTable({
                    url: options.url,           //请求url
                    method: 'POST',             // 请求方式
                    toolbar: '#toolbar',		//指定工作栏
                    columns: options.columns    // 显示列信息
                });
            }
        },

        // 表格树封装处理
        treetable: {
            init: function (options) {
                $("#bootstrap-tree-table").bootstrapTreeTable({
                    url: options.url,           // 请求url
                    // method: 'POST',             // 请求方式
                    code : options.code,          // 选取记录返回的值,用于设置父子关系
                    parentCode : options.parentCode, // 用于设置父子关系
                    ajaxParams: {
                    },            // 请求数据的ajax的data属性
                    columns: options.columns    // 显示列信息
                });
            }
        },

        // 弹出框封装处理
        modal: {

            // icon
            icon: function (type) {
                var icon = "3";
                if (type == modal_status.SUCCESS) {
                    icon = "1";
                } else if (type  == modal_status.FAIL) {
                    icon = "2";
                } else if (type == modal_status.WARNING) {
                    icon = "0";
                }
                return icon;
            },

            // 关闭弹出窗口
            close: function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            },

            // 弹出层
            open: function (title, url, width, height) {
                // 如果是移动端，就使用自适应大小的窗口
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    width = "auto";
                    height = "auto";
                }

                if ($.common.isEmpty(title)) {
                    // 不显示标题
                    title = false;
                }

                if ($.common.isEmpty(url)) {
                    url = '/404.html';
                }

                if ($.common.isEmpty(width)) {
                    width = 800;
                }

                if ($.common.isEmpty(height)) {
                    height = ($(window).height() - 50);
                }

                layer.open({
                    type: 2,									// iframe 层
                    area: [width + 'px', height + 'px'],		// 宽高
                    fix: false,									// 不固定
                    maxmin: true,								// 最大最小化
                    shade: 0.4,									// 遮罩透明度
                    title, title,								// 标题
                    content: url,								// 请求url
                    shadeClose: true,                            //开启遮罩关闭
                    btn: ["提交", "关闭"],
                    yes: function(index, layero){ // 确定按钮回调方法，layero为当前层的DOM对象
                        var iframeWindow = layero.find('iframe')[0];
                        iframeWindow.contentWindow.submitHandler();
                    },
                    cancel: function () { // 取消和关闭按钮触发的回调
                        return true; // 关闭窗口，若不想关闭，return false
                    }
                });
            },

            // 打开遮罩层
            loading: function () {
                $.blockUI({message: '<div class="loaderbox"><div class="loading-activity"></div> ' + message + '</div>'});
            },

            // 关闭遮罩层
            closeLoading: function () {
                setTimeout(function () {
                    $.unblockUI();
                }, 50);
            },

            //  消息提示并刷新父窗体
            messageReload: function (message, type) {
                layer.msg(message, {
                        icon: $.modal.icon(type),
                        time: 500,
                        shade: [0.1, '#8F8F8F']
                    },
                    function () {
                        $.modal.reload();
                    });
            },

            // 错误提示
            alertError: function (content) {
                $.modal.msg(content, modal_status.FAIL);
            },

            // 成功提示
            alertSuccess: function (content) {
                $.modal.msg(content, modal_status.SUCCESS);
            },

            alertWarning: function (content) {
                $.modal.msg(content, modal_status.WARNING);
            }
        },

        // 操作封装处理
        operate: {

            // 提交数据


            // post 请求传输
        	
        	// 删除操作
        	remove: function (id) {
        		$.modal.confirm("确定删除该条" + $.table._option.modalName + "信息吗？", function(){
        			var url = $.common.isEmpty(id) ? $.table._options.removeUrl : $.table._options.removeUrl.replace("{id}", id);
        			var data = {"ids" : id};
        			$.operate.submit(url, "post", "josn", data);
        		});
        	},
        	
        	// 批量删除操作
        	removeAll: function() {
        		
        	},

            // 添加操作
            add: function (id) {
                var url = $.common.isEmpty(id) ? $.table._options.createUrl : $.table._options.createUrl.replace("{id}", id);
                $.modal.open("添加" + $.table._options.modalName, url);
            },

            // 修改操作
            edit: function (id) {
                var url = $.table._options.updateUrl.replace("{id}", id);
                $.modal.open("修改" + $.table._options.modalName, url)
            },

            // 保存操作
            save: function (url, data) {
                $.modal.loading("正在处理中，请稍后 ...");
                $.ajax({
                    url: url,
                    type: 'POST',
                    dataType: 'JSON',
                    data: data,
                    success: function (result) {
                        $.operate.alertTips(result);
                    }
                })
            },

            // 弹出结果提示框
            alertTips: function (result) {
                // 成功
                if (result.isSuccess()) {
                    $.modal.messageReload(result.message);
                } else {
                    $.modal.alertError(result.message);
                }
                $.modal.closeLoading();
            },

            //

        },

        // 通用方法封装
        common: {

            // 判断字符串是否为空
            isEmpty: function (value) {
                if (value == null || this.trim(value) == "") {
                    return true;
                }
                return false;
            },

            // 判断字符串是否为非空串
            isNotEmpty: function (value) {
                return !$.common.isEmpty(value);
            },

            trim: function (value) {
                if (value == null) {
                    return true;
                }
                return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "");
            }

        }

    });

})(jQuery);

/** 弹窗状态码 */
modal_status = {
    SUCCESS: "success",
    FAIL: "error",
    WARNING: "warning"
};