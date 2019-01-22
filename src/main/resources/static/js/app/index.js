
$("#td_todo").click(function(){

    $("#modal_todo").val($("#td_todo").text());

});

var index = {
    init : function () {
        var _this = this;
        $('#add_task').click(function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            todo: $('#task').val(),
        };

        console.log(data);

        $.ajax({
            type: 'POST',
            url: '/todos',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('할일이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

index.init();

