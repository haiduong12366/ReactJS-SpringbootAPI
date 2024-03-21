$(window).scroll(()=>{
    if($(window).scrollTop() + $(window).height() >= $(window).height())
    {
        loadMore();
    }
})