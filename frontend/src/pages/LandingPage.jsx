import {useNavigate} from "react-router";
import NavbarHome from "../navbar_components/NavbarHome.jsx";

const LandingPage = () => {

    const navigate = useNavigate()

    return (
        <div>
            <NavbarHome/>

            <section id="hero">
                <div className="w-screen h-screen">
                    <div className="flex flex-col items-center pt-60 text-white">
                        <h1 className="text-8xl font-bold font-heading text-shadow-lg/100 p-3">Forked Fates</h1>
                        <h3 className="text-5xl font-bold font-heading text-shadow-lg/100 p-3">The Last of Us 2</h3>
                        <p className="text-3xl font-semibold font-body text-shadow-lg/100 py-10">Every Choice Leaves A Mark</p>

                        <div className="flex justify-center space-x-10">
                            <button className="p-2 px-20 py-3 border-3 rounded-xl bg-black text-white text-2xl font-body hover:font-bold hover:text-black hover:bg-white/60">Sign Up</button>

                            <button onClick={() => navigate("/Chapters")} className="p-2 px-20 py-3 border-3 rounded-xl bg-black text-white text-2xl font-body hover:font-bold hover:text-black hover:bg-white/60">Chapters</button>
                        </div>
                    </div>
                </div>
            </section>
        </div>

    )
}

export default LandingPage;


// const LandingPage = () => {
//     return (
//         // Hero Container
//         <section id="hero" className="w-screen h-screen">
//
//             <div className="max-w-6xl mx-auto px-6 py-12 md:px-0">
//                 <p>Need to return to "Loopstudios Website" tutorial on Udemy.</p>
//             </div>
//         </section>
//
//
//     )
// }