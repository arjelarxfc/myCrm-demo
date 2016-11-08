$.scrollify({
    section : "section",
    sectionName : "section-name",
    easing: "easeOutExpo",
    scrollSpeed: 1100,
    offset : 0,
    scrollbars: true,
    before:function() {},
    after:function(index, array) {
        console.log(index);
        $('#navBar').children().each(function () {
            $(this).removeClass('active');
        });
        $('#navBar').children().eq(index).addClass('active');
    },
    afterResize:function() {}
});

$('#navBar').delegate("li", "click", function (event) {
    var role = $(event.target).data('role');
     // var role = event.target.data("role");
    $.scrollify.instantMove(role);
    console.log(this);

});
