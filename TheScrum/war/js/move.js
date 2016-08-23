

$(function (){
  
 $('.choose new-task').on('click', '.left', '.left-right', '.right' ,'.choose' ,function () {

    // $('.choose li').removeClass('active');
    $(this).toggleClass('active');
  });
  // Move Items On Click
  

  $('.adding').click(function () 

  {
    if ($(this).data('value') === 'add')
     {
      $('.left .active')
      .clone(true, true).appendTo('.left-right .choose');
      $('.left .active').remove();
    }
    
    else 

    {
      $('.left li')
      .clone(true, true).appendTo('.left-right .choose');
      $('.left li').remove();
    }


    
    if ($(this).data('value') === 'add')
     {
      $('.left-right .active')
      .clone(true, true).appendTo('.right .choose');
      $('.left-right .active').remove();
    } 
    else
     {
      $('.left-right li')
      .clone(true, true).appendTo('.right .choose');
      $('.left-right li').remove();
    }

  });
 

  $('.removing').click(function ()

   {
    if ($(this).data('value') === 'remove')
     {
      $('.right .active')
      .clone(true, true).appendTo('.left-right .choose');
      $('.right .active').remove();
    }

     else 
    {
      $('.right li')
      .clone(true, true).appendTo('.left-right .choose');
      $('.right li').remove();
    }
    
    
    if ($(this).data('value') === 'remove') 
    {
      $('.left-right .active')
      .clone(true, true).appendTo('.left .choose');
      $('.left-right .active').remove();
    } 
    else
    
     {
      $('.left-right li')
      .clone(true, true).appendTo('.left .choose');
      $('.left-right li').remove();
    }

  });
  // Move Items By Double Click

 
});

