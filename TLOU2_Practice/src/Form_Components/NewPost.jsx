const NewPost = () => {
    return (
        <div className="w-1/2 h-50 mt-2 mb-16 p-3 border-2 rounded-xl border-[#A8ADA3] bg-[#8C978C]">

            {/*    Text Area and Button*/}
            <div className="flex flex-col mt-3 space-y-3 px-4">
                <input
                    type="textarea"
                    placeholder="Post here..."
                    className="p-2 px-4 h-25 border border-[#7C857C] rounded-xl bg-[#6E7C7A] text-start text-[#E7E3DA] text-lg placeholder:text-[#D4CFC4] focus:outline-none"
                />

                <div className="flex justify-end">
                    <button
                        className="px-5 py-3 rounded-md bg-[#2F3E2F] text-[#E7E3DA] hover:bg-[#253225] transition">Post
                    </button>
                </div>

            </div>

        </div>
    )
}

export default NewPost;