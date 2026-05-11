const NavbarHome = () => {
    return (
        <div id="navbarOther" className="py-8 px-20 bg-black">
            <nav className="flex justify-between font-heading font-bold text-white">

                {/* Website Name */}
                <div>
                    <h3 className="text-4xl text-shadow-black text-shadow-lg">Forked Path</h3>
                </div>

                {/* Menu */}
                <div className="flex items-center justify-center space-x-6 text-xl">
                    <div className="group">
                        <a href="/" className="text-shadow-black text-shadow-lg">Home</a>
                        <div className="mx-2  group-hover:border-b group-hover:border-white"></div>
                    </div>

                    <div className="group">
                        <a href="/Chapters" className="text-shadow-black text-shadow-lg">Chapters</a>
                        <div className="mx-2 group-hover:border-b group-hover:border-white"></div>
                    </div>

                    <div className="group">
                        <a href="/Account" className="text-shadow-black text-shadow-lg">Account</a>
                        <div className="mx-2 group-hover:border-b group-hover:border-white"></div>
                    </div>
                </div>
            </nav>
        </div>

    )
}

export default NavbarHome;