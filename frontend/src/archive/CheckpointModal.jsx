import mothAndFern from '../assets/TLOU2_Moth_and_Fern.png'

const CheckpointModal = () => {
    return (
        <div>
            <div className="border-2 rounded-xl border-black  relative w-1/2 h-96 bg-[#E8E6E3] flex flex-col items-center justify-center mt-24 mx-auto overflow-hidden shadow-xl">
                <div className="absolute inset-x-0 top-0 h-40 bg-contain bg-center" style={{backgroundImage: `url(${mothAndFern})`}}>
                </div>

                <h4 className="mt-6 text-4xl font-medium text-black border-b">Checkpoint Title</h4>
                <p className="mt-2 text-base text-black">Checkpoint Description</p>

                <div className="absolute inset-x-0 bottom-2 h-14 flex items-center justify-center space-x-15">
                    <button className="bg-[#4C6B4F] text-[#E8E6E3] font-medium outline rounded-lg py-3 px-20 hover:text-black">Choice 1</button>
                    <button className="bg-[#4C6B4F] text-[#E8E6E3] font-medium outline rounded-lg py-3 px-20 hover:text-black">Choice 2</button>


                </div>

            </div>

        </div>
    )
}

export default CheckpointModal;