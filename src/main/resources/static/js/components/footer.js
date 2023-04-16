class Footer extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.innerHTML = `
        <!-----------FOOTER--------->  
        <div class = "footer" id = "footer">
            <div class = "footer-left d-flex-col-c gap-2">
                <h1>Download our App</h1>
                <h2>Enjoy faster ordering, updates, and discounts</h2>
                <div class="d-flex-row-c gap-2">
                    <a href="#"><img width = 200px  src="images/Google-Play-Icon.png" alt=""></a>
                    <a href="#"><img width = 180px  src="images/App-store-icon-transparent-photo-12.png" alt=""></a>
                </div>
            </div>
            <div class = "footer-right">
                <h1>Follow us</h1>
                <br>
                <h2>on Facebook, Instagram and Twitter for latest news, exclusive offers and more </h2>
                <br>
                <img src="images/Facebook_f_logo_(2021).svg.png" width="50px" height="50px" alt="">
                <img src="images/pngtree-twitter-social-media-round-icon-png-image_6315985.png" width="50px" height="50px" alt="">
                <img src="images/instagram-logo-icon-png-10.jpg" width="50px" height="50px" alt="">
            </div>
        </div>
        <div class = "footer-project">
            <h3>Project Designed by Group D | EE417 Web Application Development</h3>
        </div>
    `;
    }
}

customElements.define('custom-footer', Footer);