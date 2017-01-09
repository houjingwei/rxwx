<!DOCTYPE html>
<html>
<head>
	<@h.head />
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <!-- Panel Other -->
        <div class="ibox float-e-margins">
            <div class="ibox-content">
                <div class="row row-lg">
                    <div class="col-sm-12">
                        <!-- Example Toolbar -->
                        <div class="example-wrap">
                            <div class="example">
                                <div class="btn-group hidden-xs" id="exampleToolbar" role="group">
                                    <button type="button" class="btn btn-outline btn-default">
                                        <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                                    </button>
                                    <button type="button" class="btn btn-outline btn-default">
                                        <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                                    </button>
                                </div>
                                <table id="exampleTableToolbar" data-mobile-responsive="true">
                                    <thead>
                                        
                                    </thead>
                                </table>
                            </div>
                        </div>
                        <!-- End Example Toolbar -->
                    </div>

                    
                </div>
            </div>
        </div>
        <!-- End Panel Other -->
    </div>

    
    <script>
    $('#exampleTableToolbar').bootstrapTable({  
        method: 'post',  
        url: '${path}/role/roleList',
        dataType: "json", 
        search: true,
        showRefresh: true,
        showColumns: true, 
        toolbar: '#exampleToolbar',
        iconSize: 'outline',
        icons: {
          refresh: 'glyphicon-repeat',
          toggle: 'glyphicon-list-alt',
          columns: 'glyphicon-list'
        },
        
        pagination: true,  //开启分页  
        sidePagination: 'server',//服务器端分页  
        pageNumber: 1,//默认加载页  
        pageSize: 5,//每页数据  
        pageList: [20, 50, 100, 500],//可选的每页数据  
        queryParamsType:'',
        queryParams: function (params) {  
            return {  
                startDate: $("#txtStartDate").val(),  
                endDate: $("#txtEndDate").val(),  
                merName: $("#txtMerName").val(),  
                pageSize: params.pageSize,  
                pageNumber: params.pageNumber  
            }  
        },
        columns: [
            {
                checkbox: true,
                align: 'center',
                valign: 'middle'
            },{
                field: 'name',
                title: '操作码'
            }, {
                field: 'description',
                title: '说明'
            } ,{
                title: '操作',
                align: 'center',
                width:'20%',
                formatter:function(value,row,index){
                   var e = '<button class="btn btn-primary btn-sm" type="button"><i class="fa fa-edit"></i>&nbsp;编辑</button>&nbsp';
                   var d = '<button class="btn btn-default btn-sm" type="button"><i class="fa fa-wrench"></i>&nbsp;启用</button>';
                   return e+d;
                }
            }
         ]
    });
    
     function operateFormatter(value, row, index) {
          return [
            '<a class="like" href="javascript:void(0)" title="Like">',
            '<i class="glyphicon glyphicon-heart"></i>',
            '</a>  ',
            '<a class="remove" href="javascript:void(0)" title="Remove">',
            '<i class="glyphicon glyphicon-remove"></i>',
            '</a>'
          ].join(''); 
      }
      
</script>

</body>

</html>