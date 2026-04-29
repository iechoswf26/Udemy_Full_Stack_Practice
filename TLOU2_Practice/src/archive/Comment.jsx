const Comment = () => {
    return (
        <div className="flex flex-col border border-black">
            <div className="flex flex-row justify-between">
                <p className="flex flex-row border border-black">Username</p>
                <div className="flex flex-row justify-end border border-black">
                    <p>Date</p>
                    <p>Time</p>
                </div>
            </div>


            <div className="border border-black">Previous Comment</div>

        </div>
    )
}

export default Comment;