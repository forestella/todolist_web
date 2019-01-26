
$("#td_todo").click(function(){

    $("#modal_todo").val($('#task_10 a#td_todo').text());
    console.log($('#task_10 a#td_todo').text());

});

// $("#updateTodosModal(id)").click(function () {
//     $("#")
// })



$(".td_task").click(function () {

    var checkBtn = $(this);

    var task_id = checkBtn[0].id;
    var task_name = checkBtn[0].text;

    $("#_todo_id").val(task_id);
    $("#todo_name").val(task_name);

    //alert(checkBtn);

});



    var index = {
        init: function () {
            var _this = this;
            //할일 추가
            $('#add_task').click(function () {
                _this.save();
            });

            //할일 수정
            $('#update_task').click(function () {
                //alert("업데이트 클릭")
                //참조 값이 있는 경우 참조 테이블에 추가
                _this.update();
            });

            //할일 완료
            $('#complete_task').click(function () {
                //alert("완료 클릭")
                _this.complete();
            });

            //할일 삭제[
            $('#delete_task').click(function () {
                //alert("삭제 클릭")
                _this.delete();
            });
        },
        save: function () {
            var data = {
                todo: $('#task').val(),
            };

            console.log(data);

            $.ajax({
                type: 'POST',
                url: '/todosInsert',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function () {
                alert('할일이 등록되었습니다.');
                location.reload();
            }).fail(function (error) {
                alert(error);
            });
        },
        update: function () {
            var data = {
                id: $('#_todo_id').val(),
                todo: $('#todo_name').val(),
            };

            console.log(data);

            $.ajax({
                type: 'POST',
                url: '/todosUpdate/'+data.id,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function () {
                alert('할일이 수정되었습니다.');
                location.reload();
            }).fail(function (error) {
                alert(error);
            });
        },
        complete: function () {
            var data = {
                id: $('#_todo_id').val(),
                completeYn: "Y",
            };

            console.log(data);

            $.ajax({
                type: 'POST',
                url: '/todosComplete/'+data.id,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function () {
                alert('할일이 완료 처리되었습니다.');
                location.reload();
            }).fail(function (error) {
                alert(error);
            });
        },
        delete: function () {
            var data = {
                id: $('#_todo_id').val(),
            };

            console.log(data);

            $.ajax({
                type: 'POST',
                url: '/todosDelete/'+data.id,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function () {
                alert('할일이 삭제되었습니다.');
                location.reload();
            }).fail(function (error) {
                alert(error);
            });
        }

    };

    index.init();



