const NavbarHome = () => {
    return (
        <div id="navbarHome" className="py-8 px-20 bg-black">
            <nav className="flex justify-between font-heading font-bold text-white">

                {/* Website Name */}
                <div>
                    <h3 className="text-4xl">Forked Fates</h3>
                </div>

                {/* Menu */}
                <div className="flex items-center justify-center space-x-4 text-xl">
                    <div className="group">
                        <a href="/">Home</a>
                        <div className="mx-2 group-hover:border-b group-hover:border-white"></div>
                    </div>

                    <div className="group">
                        <a href="/Chapters">Chapters</a>
                        <div className="mx-2 group-hover:border-b group-hover:border-white"></div>
                    </div>
                </div>
            </nav>
        </div>

    )
}

export default NavbarHome;