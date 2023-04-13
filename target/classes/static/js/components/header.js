class Header extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.innerHTML = `
        <!--Universal site header-->
        <header>
            <section class="logo">                
                <a href="/"><img src="/images/logo_main.jpg" alt=""></a><s></s>
                <div class="navbar">
                    <ul>
                      <li><a href="/"><b>Home</b></a></li>
                      <li><a href="/menu"><b>View Menu</b></a></li>
                      <li><a href="/about"><b>About Us</b></a></li>
                      <li><a href="/gallery"><b>Gallery</b></a></li>
                      <li><a href="/contact"><b>Contact Us</b></a></li>
                      <li><a href="/login" class="signinbtn"><b>Login</b></a></li>
                      <li><a href="/register" class="signinbtn"><b>Register</b></a></li>
                    </ul>  
                 </div>  
            </section>            
        </header>
    `;
    }
}

customElements.define('custom-header', Header);