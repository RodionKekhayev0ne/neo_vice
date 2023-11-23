
function openBut(evt, variable) {

  var i, tabcontent, tablinks;

  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
  }


  tablinks = document.getElementsByClassName("tablinks");


  for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
  }

  document.getElementById(variable).style.display = "block";
  evt.currentTarget.className += " active";
}

// JavaScript is used for toggling loading state
var form = document.querySelector('form');
form.onsubmit = function (event) {
    event.preventDefault();
    form.classList.add('signed');
};
const formElement = document.getElementById('registration'); // извлекаем элемент формы
formElement.addEventListener('submit', (e) => {
  e.preventDefault();
  const formData = new FormData(formElement);



  // Теперь у вас есть объект FormData, который содержит все данные формы
  // Вы можете получить значения полей по их именам
  const name = formData.getElementById('name');
  const email = formData.getElementById('email');
  const pass = formData.getElementById('pass');
  const status = "";


  if(formData.get("personal") != null){
    status = "user";
  }else{
    status = "admin";
  }




  var requestData = {
    name: name,
    email: email,
    pass: pass,
    role: status
  };

  // Выполнение AJAX-запроса
  $.ajax({
    url: 'localhost:8080/registration',
    type: 'GET', // или 'GET' в зависимости от вашего случая
    data: "",


  success: function(response) {
      // Обработка успешного ответа от сервера
      console.log('Успешный ответ:', response);
    },

    },

  error, function(error) {

  // Обработка ошибок
      console.error('Ошибка запроса:', error);

  });





});

jQuery(document).ready(function($) {
  $('#btn').prop({disabled: true});
  $('input[type="radio"]').change(function() {
    $('#btn').prop({disabled: false});
  });