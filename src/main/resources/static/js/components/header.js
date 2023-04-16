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
                  <li><a href="index.html"><p class="fs-xs">Home</p></a></li>
                  <li><a href="menu.html"><p class="fs-xs">View Menu</p></a></li>
                  <li><a href="about.html"><p class="fs-xs">About Us</p></a></li>
                  <li><a href="gallery.html"><p class="fs-xs">Gallery</p></a></li>
                  <li><a href="contact.html"><p class="fs-xs">Contact Us</p></a></li>
                  <li><a href="signin.html" class="signInBtn"><p class="fs-xs">Login</p></a></li>
                  <li><a href="register.html" class="signInBtn"><p class="fs-xs">Register</p></a></li>
                </ul>  
             </div>  
        </header>
    `;
    }
}

customElements.define('custom-header', Header);