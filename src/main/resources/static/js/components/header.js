class Header extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.innerHTML = `
        <!--Universal site header-->
        <header class="d-flex jc-sb header">
            <a class="ml-5 d-flex-row-c" href="index.html"><img src="images/logo_main.jpg" alt=""></a>
            <div class="navbar mr-2">
                <ul>
                  <li><a href="index.html"><b>Home</b></a></li>
                  <li><a href="menu.html"><b>View Menu</b></a></li>
                  <li><a href="about.html"><b>About Us</b></a></li>
                  <li><a href="gallery.html"><b>Gallery</b></a></li>
                  <li><a href="contact.html"><b>Contact Us</b></a></li>
                  <li><a href="signin.html" class="signInBtn"><b>Login</b></a></li>
                  <li><a href="register.html" class="signInBtn"><b>Register</b></a></li>
                </ul>  
             </div>  
        </header>
    `;
    }
}

customElements.define('custom-header', Header);