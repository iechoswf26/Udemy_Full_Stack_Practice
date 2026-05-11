const DeleteAccountModal = () => {
    return (
        //     Global Container
        <div className="flex items-center justify-center min-h-screen">

            {/*    Card Container*/}
            <div className="relative flex flex-col m-6 p-4 space-y-3 bg-white shadow-2xl">

                {/* Header */}
                <div className="flex items-center justify-center border-2 border-black bg-black">
                    <h2 className="font-heading mb-5 text-2xl font-medium text-white">Delete Your Account</h2>
                </div>

                {/* Previous Username */}
                <div>
                    <p className="font-body text-xl">Are you sure you want to delete your account? Deleting your account will remove all data.</p>
                </div>

                {/* Bottom Buttons Container */}
                <div className="flex items-center justify-center space-x-3">

                    <button className="p-2 px-5 py-3 rounded-xl text-white bg-black border-2 border-black font-body text-xl hover:text-black hover:border-2 hover:border-black hover:bg-white hover:font-semibold">Cancel</button>

                    <button className="p-2 px-5 py-3 rounded-xl border-2 border-red-600 bg-red-600 text-white font-body text-xl hover:bg-white hover:text-red-600 hover:border-2 hover:border-red-600 hover:font-semibold">Delete</button>

                </div>

            </div>

        </div>
    )
}

export default DeleteAccountModal;