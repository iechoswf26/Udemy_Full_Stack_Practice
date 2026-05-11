const PostHistory = ({id, checkpointId, username, post, date, time}) => {
    return (
        <div className="flex flex-col items-center justify-center bg-gray-300 w-10/12 rounded-lg">

            <div className="w-11/12 space-y-3 my-10">

                {/* Username */}
                <div className="flex justify-between">
                    <p className="font-heading font-medium text-2xl">{username}</p>
                </div>

                {/* Post */}
                <p className="w-full bg-white rounded-lg p-3 font-body font-medium text-xl">{post}</p>


                <div className="flex justify-between">
                    <p className="font-body font-medium text-xl text-black">{date}/{time}</p>

                    <div className="space-x-5">
                        <button className="p-2 px-5 py-3 rounded-xl border-2 border-black bg-black text-white font-body text-xl hover:bg-white hover:text-black hover:border-2 hover:border-black hover:font-semibold">Edit</button>
                        <button className="p-2 px-5 py-3 rounded-xl border-2 border-black bg-black text-white font-body text-xl hover:bg-white hover:text-black hover:border-2 hover:border-black hover:font-semibold">Delete</button>
                    </div>

                </div>

            </div>
        </div>

    )
}

export default PostHistory;