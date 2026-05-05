const Navbar = () => {
    return (
        <div>
        {/*    Hero Section*/}
            <section id="hero">

                {/*    Hero Container*/}
                <div className="container max-w-6xl mx-auto px-6 py-12">

                {/*    Menu/Logo Container*/}
                    <nav className="flex flex-row items-center justify-between font-heading text-[#253225]">

                    {/*    Website Name */}
                        <h3 className="text-4xl font-bold">The Last of Us Part 2</h3>

                        {/* Menu */}
                        <div className="hidden h-10 font-heading md:flex md:space-x-8">
                            <div className="group">
                                <a href="#">Home</a>
                                <div className="mx-2 group-hover:border-b group-hover:border-white"></div>
                            </div>
                        </div>

                        <div className="hidden h-10 font-heading md:flex md:space-x-8">
                            <div className="group">
                                <a href="#">Carousel</a>
                                <div className="mx-2 group-hover:border-b group-hover:border-white"></div>
                            </div>
                        </div>

                    </nav>

                </div>

            </section>

        </div>



    )
}

export default Navbar;

// Name of website: The Last Perspective

// <ul>
//     <li><a href="/">LandingPage</a></li>
//     <li><a href="/Chapters">Chapters</a></li>
// </ul>