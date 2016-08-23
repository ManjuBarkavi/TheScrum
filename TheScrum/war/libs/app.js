var main = function() {
$('.btn').click(function() {
    var post = $('.status-box').val();
    $('<li>').text(post).appendTo('.posts');
  });

}

$(document).ready(main);
