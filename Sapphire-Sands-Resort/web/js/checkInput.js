const errorText = document.getElementById("errorText");
const loginButton = document.getElementById("loginButton");

// check-input employee
let user = "",
  fullName = "",
  date = "",
  address = "",
  tel = "",
  email = "",
  pass = "",
  rePass = "";

  
function ValidateTel(tel) {
  var regex = /^0([3|5|7|8|9])([0-9]){8}$/;

  if (regex.test(tel)) {
    return true;
  }
  return false;
}

function ValidateEmail(email) {
  var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  if (regex.test(email)) {
    return true;
  }
  return false;
}



function checkUser(event) {
  user = event.target.value;

  if (user.length === 0) {
    errorText.textContent = "Vui lòng không được để trống!";
  } else if (user.length < 3) {
    errorText.textContent = "Vui lòng nhập trên 3 kí tự!";
  } else {
    errorText.innerHTML = "";
  }

  checkButtonEmployee();
}

function checkName(event) {
  fullName = event.target.value;

  if (fullName.length === 0) {
    errorText.textContent = "Vui lòng không được để trống!";
  } else if (fullName.length < 3) {
    errorText.textContent = "Vui lòng nhập trên 3 kí tự!";
  } else {
    errorText.innerHTML = "";
  }

  checkButtonEmployee();
}

function checkDate(event) {
  date = event.target.value;

  if (date.length === 0) {
    errorText.textContent = "Vui lòng không được để trống!";
  } else {
    errorText.innerHTML = "";
  }
  checkButtonEmployee();
}

function checkAddress(event) {
  address = event.target.value;

  if (address.length === 0) {
    errorText.textContent = "Vui lòng không được để trống!";
  } else if (address.length < 3) {
    errorText.textContent = "Vui lòng nhập trên 3 kí tự!";
  } else {
    errorText.innerHTML = "";
  }

  checkButtonEmployee();
}

function checkTel(event) {
  tel = event.target.value;

  if (tel.length === 0) {
    errorText.textContent = "Vui lòng không được để trống!";
  } else if (!ValidateTel(tel)) {
    errorText.textContent = "Vui lòng nhập đúng định dạng số điện thoại !";
  } else {
    errorText.innerHTML = "";
  }

  checkButtonEmployee();
}

function checkPass(event) {
  pass = event.target.value;

  if (pass.length === 0) {
    errorText.textContent = "Vui lòng không được để trống!";
  } else if (pass.length < 3) {
    errorText.textContent = "Vui lòng nhập mật khẩu trên 3 kí tự!";
  } else {
    errorText.innerHTML = "";
  }

  checkButtonEmployee();
}

function checkRePass(event) {
  rePass = event.target.value;

  if (rePass.length === 0) {
    errorText.textContent = "Vui lòng không được để trống!";
  } else if (rePass !== pass) {
    errorText.textContent = "Mật khẩu ở trên không khớp !";
  } else {
    errorText.innerHTML = "";
  }

  checkButtonEmployee();
}

function checkEmail(event) {
  email = event.target.value;

  if (email.length === 0) {
    errorText.textContent = "Vui lòng không được để trống!";
  } else if (!ValidateEmail(email)) {
    errorText.textContent = "Vui lòng nhập đúng định dạng của email !";
  } else {
    errorText.innerHTML = "";
  }

  checkButtonEmployee();
}

function checkButtonEmployee() {
  if (
    user.length >= 3 &&
    fullName.length >= 3 &&
    date.length !== 0 &&
    address.length >= 3 &&
    ValidateTel(tel) &&
    ValidateEmail(email) &&
    pass.length >= 3 &&
    rePass === pass
  ) {
    loginButton.disabled = false;
  } else {
    loginButton.disabled = true;
  }
}

// End code check Employee

// Check-input Manager
const errorTextManager = document.getElementById("errorTextManager");
const loginButtonManager = document.getElementById("loginButtonManager");

let userManager = "",
  fullNameManager = "",
  dateManager = "",
  addressManager = "",
  telManager = "",
  emailManager = "",
  passManager = "",
  rePassManager = "";

function ValidateTelManager(telManager) {
  var regex = /^0([3|5|7|8|9])([0-9]){8}$/;

  if (regex.test(telManager)) {
    return true;
  }
  return false;
}

function ValidateEmailManager(emailManager) {
  var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  if (regex.test(emailManager)) {
    return true;
  }
  return false;
}

function checkUserManager(event) {
  userManager = event.target.value;

  if (userManager.length === 0) {
    errorTextManager.textContent = "Vui lòng không được để trống!";
  } else if (userManager.length < 3) {
    errorTextManager.textContent = "Vui lòng nhập trên 3 kí tự!";
  } else {
    errorTextManager.innerHTML = "";
  }

  checkButtonManager();
}

function checkNameManager(event) {
  fullNameManager = event.target.value;

  if (fullNameManager.length === 0) {
    errorTextManager.textContent = "Vui lòng không được để trống!";
  } else if (fullNameManager.length < 3) {
    errorTextManager.textContent = "Vui lòng nhập trên 3 kí tự!";
  } else {
    errorTextManager.innerHTML = "";
  }

  checkButtonManager();
}

function checkDateManager(event) {
  dateManager = event.target.value;

  if (dateManager.length === 0) {
    errorTextManager.textContent = "Vui lòng không được để trống!";
  } else {
    errorTextManager.innerHTML = "";
  }
  checkButtonManager();
}

function checkAddressManager(event) {
  addressManager = event.target.value;

  if (addressManager.length === 0) {
    errorTextManager.textContent = "Vui lòng không được để trống!";
  } else if (addressManager.length < 3) {
    errorTextManager.textContent = "Vui lòng nhập trên 3 kí tự!";
  } else {
    errorTextManager.innerHTML = "";
  }

  checkButtonManager();
}

function checkTelManager(event) {
  telManager = event.target.value;

  if (telManager.length === 0) {
    errorTextManager.textContent = "Vui lòng không được để trống!";
  } else if (!ValidateTelManager(telManager)) {
    errorTextManager.textContent = "Vui lòng nhập đúng định dạng số điện thoại !";
  } else {
    errorTextManager.innerHTML = "";
  }

  checkButtonManager();
}

function checkPassManager(event) {
  passManager = event.target.value;

  if (passManager.length === 0) {
    errorTextManager.textContent = "Vui lòng không được để trống!";
  } else if (passManager.length < 3) {
    errorTextManager.textContent = "Vui lòng nhập mật khẩu trên 3 kí tự!";
  } else {
    errorTextManager.innerHTML = "";
  }

  checkButtonManager();
}

function checkRePassManager(event) {
  rePassManager = event.target.value;

  if (rePassManager.length === 0) {
    errorTextManager.textContent = "Vui lòng không được để trống!";
  } else if (rePassManager !== passManager) {
    errorTextManager.textContent = "Mật khẩu ở trên không khớp !";
  } else {
    errorTextManager.innerHTML = "";
  }

  checkButtonManager();
}

function checkEmailManager(event) {
  emailManager = event.target.value;

  if (emailManager.length === 0) {
    errorTextManager.textContent = "Vui lòng không được để trống!";
  } else if (!ValidateEmailManager(emailManager)) {
    errorTextManager.textContent = "Vui lòng nhập đúng định dạng của email !";
  } else {
    errorTextManager.innerHTML = "";
  }

  checkButtonManager();
}

function checkButtonManager() {
  if (
    userManager.length >= 3 &&
    fullNameManager.length >= 3 &&
    dateManager.length !== 0 &&
    addressManager.length >= 3 &&
    ValidateTelManager(telManager) &&
    ValidateEmailManager(emailManager) &&
    passManager.length >= 3 &&
    rePassManager === passManager
  ) {
    loginButtonManager.disabled = false;
  } else {
    loginButtonManager.disabled = true;
  }
}
// end check manager


// check-input service
const errorTextService = document.getElementById("errorTextService");
const createButtonService = document.getElementById("createButtonService");

let serviceName = "";
let servicePrice = "";

function checkService(event) {
  serviceName = event.target.value;

  if (serviceName.length === 0) {
    errorTextService.textContent = "Vui lòng không để trống!";
  } else if (serviceName.length < 3) {
    errorTextService.textContent = "Vui lòng nhập ít nhất 3 kí tự!";
  } else {
    errorTextService.innerHTML = "";
  }

  checkButtonService();
}

function checkPriceService(event) {
  servicePrice = event.target.value;

  if (servicePrice.length === 0) {
    errorTextService.textContent = "Vui lòng không để trống!";
  } else if(validateNumber(servicePrice)){
    errorTextService.textContent = "Vui lòng nhập kiểu dữ liệu số !";
  } else {
    errorTextService.innerHTML = "";
  }

  checkButtonService();
}

function validateNumber(servicePrice) {
  if (isNaN(servicePrice)) {
    return true;
  } else {
    return false;
  }
}

function checkButtonService() {
  if (
    serviceName.length >= 3 && 
    !validateNumber(servicePrice)
    ) {
    createButtonService.disabled = false;
  } else {
    createButtonService.disabled = true;
  }
}

// service update

const messageServiceUpdate = document.getElementById("messageServiceUpdate");
const updateButtonService = document.getElementById("updateButtonService");

let nameServiceUpdate= "", priceUpdate = "";

function updateNameService(event){
  nameServiceUpdate = event.target.value;

  if (nameServiceUpdate.length === 0) {
    messageServiceUpdate.textContent = "Vui lòng không để trống!";
  } else if (nameServiceUpdate.length < 3) {
    messageServiceUpdate.textContent = "Vui lòng nhập ít nhất 3 kí tự!";
  } else {
    messageServiceUpdate.innerHTML = "";
  }

  checkButtonUpdate();
}

function priceServiceUpdate(event) {
  priceUpdate = event.target.value;

  if (priceUpdate.length === 0) {
    messageServiceUpdate.textContent = "Vui lòng không để trống!";
  } else if(validateNumber(priceUpdate)){
    messageServiceUpdate.textContent = "Vui lòng nhập kiểu dữ liệu số !";
  } else {
    messageServiceUpdate.innerHTML = "";
  }

  checkButtonService();
}

function validateNumber(priceUpdate) {
  if (isNaN(priceUpdate)) {
    return true;
  } else {
    return false;
  }
}

function checkButtonUpdate(){
  if (
    nameServiceUpdate.length >= 3 && 
    !validateNumber(servicePrice)
    ) {
    updateButtonService.disabled = false;
  } else {
    updateButtonService.disabled = true;
  }
}

// Manager update

const messageManagerUpdate = document.getElementById("messageManagerUpdate");
const updateButtonManager = document.getElementById("updateButtonManager");

let nameUpdate = "",
dobUpdate = "",
addressUpdate = "",
phoneUpdate="",
emailUpdate = ""
;

function UpdateValidateTelManager(result) {
  var regex = /^0([3|5|7|8|9])([0-9]){8}$/;

  if (regex.test(result)) {
    return true;
  }
  return false;
}

function UpdateValidateEmailManager(result) {
  var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  if (regex.test(result)) {
    return true;
  }
  return false;
}

function updateManagerName(event){
  nameUpdate = event.target.value;

  if (nameUpdate.length === 0) {
    messageManagerUpdate.textContent = "Vui lòng không được để trống!";
  } else if (nameUpdate.length < 3) {
    messageManagerUpdate.textContent = "Vui lòng nhập trên 3 kí tự!";
  } else {
    messageManagerUpdate.innerHTML = "";
  }

  updateManagerButton();
}

function checkUpdateDateManager(event){
  dobUpdate = event.target.value;

  if (dobUpdate.length === 0) {
    messageManagerUpdate.textContent = "Vui lòng không được để trống!";
  } else {
    messageManagerUpdate.innerHTML = "";
  }
  updateManagerButton();
}

function updateAddressManager(event){
  addressUpdate = event.target.value;

  if (addressUpdate.length === 0) {
    messageManagerUpdate.textContent = "Vui lòng không được để trống!";
  } else if (addressUpdate.length < 3) {
    messageManagerUpdate.textContent = "Vui lòng nhập trên 3 kí tự!";
  } else {
    messageManagerUpdate.innerHTML = "";
  }

  updateManagerButton();
}

function updatePhoneManager(event){
  phoneUpdate = event.target.value;

  if (phoneUpdate.length === 0) {
    messageManagerUpdate.textContent = "Vui lòng không được để trống!";
  } else if (!UpdateValidateTelManager(phoneUpdate)) {
    messageManagerUpdate.textContent = "Vui lòng nhập đúng định dạng số điện thoại !";
  } else {
    messageManagerUpdate.innerHTML = "";
  }

  updateManagerButton();
}

function updateEmailManager(event){
  emailUpdate = event.target.value;

  if (emailUpdate.length === 0) {
    messageManagerUpdate.textContent = "Vui lòng không được để trống!";
  } else if (!UpdateValidateEmailManager(emailUpdate)) {
    messageManagerUpdate.textContent = "Vui lòng nhập đúng định dạng của email !";
  } else {
    messageManagerUpdate.innerHTML = "";
  }

  updateManagerButton();
}

function updateManagerButton(){
  if (
    nameUpdate.length >= 3 &&
    dobUpdate.length !== 0 &&
    addressUpdate.length >= 3 &&
    UpdateValidateTelManager(phoneUpdate) &&
    UpdateValidateEmailManager(emailUpdate)
  ) {
    updateButtonManager.disabled = false;
  } else {
    updateButtonManager.disabled = true;
  }
}
// Employee update

const messageEmployeeUpdate = document.getElementById("messageEmployeeUpdate");
const updateEmployeeButton= document.getElementById("updateEmployeeButton");

let nameUpdateE = "",
dobUpdateE = "",
addressUpdateE = "",
phoneUpdateE="",
emailUpdateE = ""
;

function updateEmployeeName(event){
  nameUpdateE = event.target.value;

  if (nameUpdateE.length === 0) {
    messageEmployeeUpdate.textContent = "Vui lòng không được để trống!";
  } else if (nameUpdateE.length < 3) {
    messageEmployeeUpdate.textContent = "Vui lòng nhập trên 3 kí tự!";
  } else {
    messageEmployeeUpdate.innerHTML = "";
  }

  updateButtonEmployee();
}

function updateEmployeeDate(event){
  dobUpdateE = event.target.value;

  if (dobUpdateE.length === 0) {
    messageEmployeeUpdate.textContent = "Vui lòng không được để trống!";
  } else {
    messageEmployeeUpdate.innerHTML = "";
  }
  updateButtonEmployee();
}

function updateEmployeeAddress(event){
  addressUpdateE = event.target.value;

  if (addressUpdateE.length === 0) {
    messageEmployeeUpdate.textContent = "Vui lòng không được để trống!";
  } else if (addressUpdateE.length < 3) {
    messageEmployeeUpdate.textContent = "Vui lòng nhập trên 3 kí tự!";
  } else {
    messageEmployeeUpdate.innerHTML = "";
  }

  updateButtonEmployee();
}

function updateEmployeePhone(event){
  phoneUpdateE = event.target.value;

  if (phoneUpdateE.length === 0) {
    messageEmployeeUpdate.textContent = "Vui lòng không được để trống!";
  } else if (!UpdateValidateTelManager(phoneUpdateE)) {
    messageEmployeeUpdate.textContent = "Vui lòng nhập đúng định dạng số điện thoại !";
  } else {
    messageEmployeeUpdate.innerHTML = "";
  }

  updateButtonEmployee();
}

function updateEmployeeEmail(event){
  emailUpdateE = event.target.value;

  if (emailUpdateE.length === 0) {
    messageEmployeeUpdate.textContent = "Vui lòng không được để trống!";
  } else if (!UpdateValidateEmailManager(emailUpdateE)) {
    messageEmployeeUpdate.textContent = "Vui lòng nhập đúng định dạng của email !";
  } else {
    messageEmployeeUpdate.innerHTML = "";
  }

  updateButtonEmployee();
}

function updateButtonEmployee(){
  if (
    nameUpdateE.length >= 3 &&
    dobUpdateE.length !== 0 &&
    addressUpdateE.length >= 3 &&
    UpdateValidateTelManager(phoneUpdateE) &&
    UpdateValidateEmailManager(emailUpdateE)
  ) {
    updateEmployeeButton.disabled = false;
  } else {
    updateEmployeeButton.disabled = true;
  }
}

//check Cus register 
const messCusFullName = document.getElementById("messCusFullName");
const messCusDOB = document.getElementById("messCusDOB");
const messCusPhone = document.getElementById("messCusPhone");
const messCusEmail = document.getElementById("messCusEmail");
const messCusCCCD = document.getElementById("messCusCCCD");
const messCusUser = document.getElementById("messCusUser");
const messCusPass = document.getElementById("messCusPass");
const messCusRePass = document.getElementById("messCusRePass");

const registerButtonCus = document.getElementById("registerButtonCus");

let cusName="", 
        cusPhone= "", 
        cusMail ="", 
        cusCCCD="", 
        cusDOB="",
        cusUser ="", 
        cusPass="", 
        cusRePass="";

function cusNameRegister(event){
    cusName = event.target.value;
    
    if(cusName.length === 0){
        messCusFullName.textContent = "Vui lòng không để trống !"
    }else if(cusName.length <3){
        messCusFullName.textContent = "Vui lòng nhập trên 3 kí tự"
    }else{
        messCusFullName.innerHTML = ""
    }
    checkRegisterButtonCus();
}

function cusPhoneRegister(event){
    cusPhone = event.target.value;
    
    if(cusPhone.length === 0){
       messCusPhone.textContent = "Vui lòng không để trống !" 
    }else if(!UpdateValidateTelManager(cusPhone)){
        messCusPhone.textContent = "Vui lòng nhập đúng định dạng số điện thoại !"
    }else {
        messCusPhone.innerHTML = "";
    }
    checkRegisterButtonCus();
}

function cusEmailRegister(event){
    cusMail = event.target.value;
    
    if(cusMail.length === 0){
      messCusEmail.textContent = "Vui lòng không để trống !" 
    }else if(!UpdateValidateEmailManager(cusMail)){
        messCusEmail.textContent = "Vui lòng nhập đúng định dạng email!"
    }else{
        messCusEmail.textContent =""
    }
    checkRegisterButtonCus();
}

function cusCCCDRegister(event){
    cusCCCD = event.target.value;
    
    if(cusCCCD.length === 0){
       messCusCCCD.textContent = "Vui lòng không để trống !"
    }else if(cusCCCD.length < 12 || cusCCCD.length > 12){
        messCusCCCD.textContent = "Vui lòng nhập 12 kí tự !"
    }else{
        messCusCCCD.textContent = ""
    }
    checkRegisterButtonCus();
}

function cus_DOB(event) {
    cusDOB = event.target.value;
    
   if (cusDOB.length === 0) {
    messCusDOB.textContent = "Vui lòng không được để trống!";
  } else {
    messCusDOB.innerHTML = "";
  }
  checkRegisterButtonCus();
    
}

function cusUserRegister(event){
    cusUser = event.target.value;
    
    if(cusUser.length === 0){
        messCusUser.textContent = "Vui lòng không để trống !"
    }else if (cusUser.length < 3){
        messCusUser.textContent = "Vui lòng nhập trên 3 kí tự !"
    }else{
        messCusUser.textContent =" ";
    }
    checkRegisterButtonCus();
}

function cusPassRegister(event){
    cusPass = event.target.value;
    
    if(cusPass.length === 0){
        messCusPass.textContent = "Vui lòng không để trống !"
    }else if(cusPass.length < 3){
        messCusPass.textContent = "Vui lòng nhập trên 3 kí tự  !"
    }else {
        messCusPass.textContent = ""
    }
    checkRegisterButtonCus();
}
function cusRePassRegister(event){
    cusRePass = event.target.value;
    
    if(cusRePass.length === 0){
        messCusRePass.textContent = "Vui lòng không để trống !"
    }else if (cusRePass !== cusPass){
        messCusRePass.textContent = " Mật khẩu không khớp !"
    }else{
        messCusRePass.textContent = ""
    }
    checkRegisterButtonCus();
}

function checkRegisterButtonCus(){
  if (
    cusName.length >= 3 &&
    cusDOB.length !== 0 &&
    cusCCCD.length === 12 &&
    cusUser.length >= 3 &&
    cusPass.length >=3 &&
    cusRePass === cusPass &&
    UpdateValidateTelManager(cusPhone) &&
    UpdateValidateEmailManager(cusMail)
  ) {
    registerButtonCus.disabled = false;
  } else {
    registerButtonCus.disabled = true;
  }
}

//check search room
const searchRoom = document.getElementById("searchRoom");
const messCheckIn = document.getElementById("messCheckIn");
const messCheckOut = document.getElementById("messCheckOut");

let checkInroom = "";
let checkOutroom = "";

function checkIn(event) {
    checkInroom = event.target.value;
    
    if (checkInroom.length === 0) {
        messCheckIn.textContent = "Vui lòng không để trống!";
    } else {
        messCheckIn.textContent = "";
    }
    checkSearchRoomButton();
}

function checkOut(event) {
    checkOutroom = event.target.value;
    
    if (checkOutroom.length === 0) {
        messCheckOut.textContent = "Vui lòng không để trống!";
    } else {
        messCheckOut.textContent = "";
    }
    checkSearchRoomButton();
}

function checkSearchRoomButton() {
    const currentDate = new Date().toISOString().split('T')[0]; 
    if (checkInroom.length !== 0 && checkOutroom.length !== 0 && checkInroom >= currentDate && checkOutroom >= currentDate && checkInroom <= checkOutroom) {
        searchRoom.disabled = false;
    } else {
        searchRoom.disabled = true;
    }
}