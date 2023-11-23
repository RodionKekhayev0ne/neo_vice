let flag = false;
        rotate = 0;

        $('.qmenu').click(function () {
          if(!flag){
              rotate+=45;
            $('.dd').css({
                transform: 'rotate(' + rotate + 'deg)',
                transition: 0.75+'s'
            });
           $('.menu-element').slideDown();
          }else{
            rotate+=45;
           $('.menu-element').slideUp();
           $('.dd').css({
                transform: 'rotate(' + rotate + 'deg)',
                transition: 0.75+'s'
            });
          }
          flag = !flag;
          
        });

        $(document).ready(function(){
  $(".owl-carousel").owlCarousel();
        
});


var elements = document.querySelectorAll('.offer');

elements.forEach(function(element) {
  element.addEventListener('click', function(event) {
    let flag2 = false;
   let rotate2 = 0;

   

      if(!flag2){
          rotate2+=90;
        $('.btn').css({
            transform: 'rotate(' + rotate + 'deg)',
            transition: 0.75+'s'
        });
       $('.details').slideDown();
      }else{
        rotate2-=90;
       $('.details').slideUp();
       $('.btn').css({
            transform: 'rotate(' + rotate + 'deg)',
            transition: 0.75+'s'
        });
      }
      flag2 = !flag2;
      
    });
  });



        $(document).ready(function(){
  $(".owl-carousel").owlCarousel();
        
});


