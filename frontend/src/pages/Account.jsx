import NavbarOther from "../navbar_components/NavbarOther.jsx";
import React from "react";
import EditUsernameModal from "../account_components/EditUsernameModal.jsx";
import DeleteAccountModal from "../account_components/DeleteAccountModal.jsx";

const Account = () => {
    return (
        <div>
            <NavbarOther/>

            {/*<EditUsernameModal/>*/}
            {/*<DeleteAccountModal/>*/}

            <div className="flex flex-col my-20 mx-80">

                <div className="border-b-2 border-gray-400">

                    {/* Header */}
                    <div className="border-b-4 border-black p-2 pb-8 mb-5">
                        <h1 className="font-heading font-medium text-6xl">Account Settings</h1>
                    </div>

                    {/* Username */}
                    <div className="space-y-2 p-2 my-2">
                        <h6 className="font-heading font-medium text-2xl">Username</h6>

                        <div className="flex flex-row items-center justify-between">
                            <p className="font-body text-xl">Your username is [insert username].</p>

                            <div className="flex flex-row space-x-10">

                                <button className="p-2 px-10 py-3 rounded-xl bg-black text-white font-body text-xl hover:bg-white hover:text-black hover:border-2 hover:border-black">Edit</button>

                            </div>
                        </div>
                    </div>

                    {/*    Email */}
                    <div className="space-y-2 p-2 my-2">
                        <h6 className="font-heading font-medium text-2xl">Email</h6>

                        <div className="flex flex-row items-center justify-between">
                            <p className="font-body text-xl">Your email is [insert email].</p>
                        </div>
                    </div>

                    {/*    Birthdate */}
                    <div className="space-y-2 p-2 my-2">
                        <h6 className="font-heading font-medium text-2xl">Birthdate</h6>

                        <div className="flex flex-row items-center justify-between">
                            <p className="font-body text-xl">Your birthdate is [insert birthdate].</p>
                        </div>
                    </div>

                </div>

                {/*    Delete Account */}
                <div className="space-y-4 p-2 my-4">
                    <h6 className="font-heading font-medium text-2xl">Delete Account</h6>

                    <div className="flex flex-row items-center justify-between">
                        <p className="font-body text-xl">Do you want to delete your account? Deleting your account will remove all associated data.</p>
                    </div>

                    <div className="flex flex-col items-center">
                        <button className="p-2 px-10 py-3 rounded-xl bg-black text-white font-body text-xl hover:bg-red-700 hover:text-white hover:border-2 hover:font-medium">Delete Account</button>
                    </div>
                </div>

            </div>

        </div>
    )
}

export default Account;