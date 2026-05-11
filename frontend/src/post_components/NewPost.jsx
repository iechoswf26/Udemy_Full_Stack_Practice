const NewPost = () => {
    return (
        <div className="flex flex-col items-center justify-center bg-gray-300 w-10/12 rounded-lg">

            <div className="w-11/12 space-y-3 my-10">

                <textarea
                    placeholder="Post here..."
                    className="w-full bg-white border-2 border-black rounded-lg placeholder:font-body placeholder:font-medium placeholder:text-xl p-3"
                />

                <div className="flex justify-end">
                    <button className="p-2 px-5 py-3 rounded-xl border-2 border-black bg-black text-white font-body text-xl hover:bg-white hover:text-black hover:border-2 hover:border-black hover:font-semibold" >Post</button>
                </div>

            </div>
        </div>
    )
}

export default NewPost;


