import {useNavigate} from "react-router";
import NavbarHome from "../navbar_components/NavbarHome.jsx";
import SignUpModal from "../account_components/SignUpModal.jsx";
import React, {useState} from "react";

const LandingPage = () => {

    const navigate = useNavigate()

    const [signUpModal, setSignUpModal] = useState(false)

    const toggleModal = () => {
        setSignUpModal(!signUpModal)
    }

    return (
        <div>
            <NavbarHome/>
            <SignUpModal signUpModal={signUpModal} toggleModal={toggleModal}/>

            <section id="hero">
                <div className="w-screen h-screen">
                    <div className="flex flex-col items-center pt-60 text-white">
                        <h1 className="text-8xl font-bold font-heading text-shadow-black text-shadow-lg p-3">Forked</h1>
                        <h3 className="text-5xl font-bold font-heading text-shadow-black text-shadow-lg p-3">The Last of Us 2</h3>
                        <p className="text-3xl font-semibold font-body text-shadow-black text-shadow-lg py-10">Every Choice Leaves A Mark</p>

                        <div onClick={toggleModal} className="flex justify-center space-x-10">
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
