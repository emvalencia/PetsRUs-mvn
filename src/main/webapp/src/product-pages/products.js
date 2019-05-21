var phone_is_valid       = false;
var cc_is_valid          = false;
var email_is_valid       = false;
var all_fields_populated = false;

function send_email()
{
    var email_address = document.forms['submit-order-form']['email-address'].value;
    var product_name  = document.getElementById('product-name').textContent;
    var product_desc  = document.getElementById('product-description').textContent;
    var product_id    = document.getElementById('product-id-num').textContent;
    var product_price = document.getElementById('product-price').textContent;
    var quantity      = document.forms['submit-order-form']['quantity'].value;
    var nl = "%0D%0A"

    var subject = "PetsRUs Purchase Confirmation: " + product_desc;
    var body    = "The following items were purchased: " + nl + nl +
                    "Product: " + product_name + nl + 
                    "Product Description: " + product_desc + nl +
                    "Total Items: " + quantity + ", Price (per item): " + product_price;

    window.open('mailto:' + email_address + '?subject=' + subject + '&body=' + body);
}

function updateAllStylings(element)
{
    if(element == 'credit-card')
        adjustCCInputStyles();
    else if(element == 'phone')
        adjustPhoneInputStyles();
    else if(element == 'email-address')
        adjustEmailStyles();
    else
    {
        if(!document.forms['submit-order-form'][element].checkValidity())
        {
            if(document.getElementById(element) != null)
            {
                document.getElementById(element).classList.add('is-invalid');   
            }
        }
        else
        {
            document.getElementById(element).classList.remove('is-invalid');
            document.getElementById(element).classList.add('is-valid');
        }
    }
}

function check_fields_populated()
{
    var fields = ['quantity', 'first-name', 'last-name', 'inputAddress',
                  'inputCity', 'inputZip', 'csc', 'inputState', 'inputShipping', 'inputCreditCardType'];

    for(var f = 0; f < fields.length; f++)
    {
        if(document.forms['submit-order-form'][fields[f]].value == "")
        {
            this.all_fields_populated = false;
            return;
        }
    }

    this.all_fields_populated = true;
}

function validate_form(element)
{
    this.phone_is_valid = false;
    this.cc_is_valid    = false;
    this.email_is_valid = false;

    this.validateCCInput();
    this.validatePhoneInput();
    this.validateEmailAddress();
    this.check_fields_populated();
    this.updateAllStylings(element);

    if(this.all_fields_populated && cc_is_valid && document.forms['submit-order-form']['credit-card'].value !="" && 
        phone_is_valid && document.forms['submit-order-form']['phone'].value != "" &&
        email_is_valid && document.forms['submit-order-form']['email-address'].value != "")
        {
            document.getElementById('checkout-btn').disabled = false;
        }
    else
        document.getElementById('checkout-btn').disabled = true;
}

function validateCCInput()
{
    var re = /\b(?:\d{4}[ -]?){3}(?=\d{4}\b)/; 
    var credit_card = document.forms['submit-order-form']['credit-card'].value;
    var is_cc_valid = re.exec(credit_card);

    if (!is_cc_valid || credit_card == "")
        this.cc_is_valid = false;  
    else if (is_cc_valid)
        this.cc_is_valid = true;
}

function adjustCCInputStyles()
{
    var re = /\b(?:\d{4}[ -]?){3}(?=\d{4}\b)/; 
    var credit_card = document.forms['submit-order-form']['credit-card'].value;
    var is_cc_valid = re.exec(credit_card);


    if (!is_cc_valid || credit_card == "")
        document.getElementById('credit-card').classList.add('is-invalid');  
    else if (is_cc_valid)
    {
        document.getElementById('credit-card').classList.remove('is-invalid');
        document.getElementById('credit-card').classList.add('is-valid');
    }
}

function validatePhoneInput()
{
    var re = /(?:\d{3}|\(\d{3}\))([-\/\.])\d{3}\1\d{4}/; 

    var phone_number = document.forms['submit-order-form']['phone'].value;
    var is_phone_valid = re.exec(phone_number); 

    if (!is_phone_valid || phone_number == "")
        this.phone_is_valid = false;  
    else if(is_phone_valid)
        this.phone_is_valid = true; 
}

function adjustPhoneInputStyles()
{
    var re = /(?:\d{3}|\(\d{3}\))([-\/\.])\d{3}\1\d{4}/; 

    var phone_number = document.forms['submit-order-form']['phone'].value;
    var is_phone_valid = re.exec(phone_number); 

    if (!is_phone_valid || phone_number == "")
        document.getElementById('phone').classList.add('is-invalid');  
    else if(is_phone_valid)
    {
        document.getElementById('phone').classList.remove('is-invalid');
        document.getElementById('phone').classList.add('is-valid');  
    }  
}

function validateEmailAddress()
{
    var email = document.forms['submit-order-form']['email-address'].value;

    if (email != "")
    {
        var temp_add_arr = email.split("@");

        if (temp_add_arr.length > 1)
        {
            var email_host = temp_add_arr[1].split(".");

            if(email_host.length > 1 && email_host[1] != "")
            {
                this.email_is_valid = true;
                return;
            }
        }
    }
    else 
        this.email_is_valid = false;

}

function adjustEmailStyles()
{
    var email = document.forms['submit-order-form']['email-address'];

    if(!email_is_valid)
        document.getElementById('email-address').classList.add('is-invalid');
    else if(email_is_valid)
    {
        document.getElementById('email-address').classList.remove('is-invalid');  
        document.getElementById('email-address').classList.add('is-valid');  
    }
}

function processCheckout()
{
    if(email_is_valid && cc_is_valid && phone_is_valid && all_fields_populated)
        this.send_email();
    else  
        console.log("incorrect checkout");
}

function handleClick(element) 
{

    console.log(element);

    /* switch to main pet page */
    if (element == 'dog') window.location.href = "dog.html";
    else if (element == 'cat') window.location.href = "cat.html";
    else if (element == 'reptile') window.location.href = "reptile.html";

    /* switch to dog pages */
    else if (element == 'dog-food') window.location.href = "dog-pages/dog-food.html";
    else if (element == 'dog-toy') window.location.href = "dog-pages/dog-toy.html";
    else if (element == 'dog-harness') window.location.href = "dog-pages/dog-harness.html";
    else if (element == 'dog-treat') window.location.href = "dog-pages/dog-treat.html";

    /* switch to cat pages */
    else if (element == 'cat-food') window.location.href = "cat-pages/cat-food.html";
    else if (element == 'cat-playground') window.location.href = "cat-pages/cat-playground.html";
    else if (element == 'cat-carrier') window.location.href = "cat-pages/cat-carrier.html";

    /* switch to reptile pages */
    else if (element == 'reptile-food') window.location.href = "reptile-pages/reptile-food.html";
    else if (element == 'reptile-habitat') window.location.href = "reptile-pages/reptile-habitat.html";
    else if (element == 'reptile-meds') window.location.href = "reptile-pages/reptile-meds.html";
    
    /* else */
    // window.location.href = "../error-page.html";
}