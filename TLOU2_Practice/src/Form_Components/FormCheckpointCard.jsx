import mothAndFern from '../assets/TLOU2_Moth_and_Fern.png'

const FormCheckpointCard = () => {
    return (
    //     Card
    <div className="bg-[#8C978C] p-2 mx-6 mb-10 rounded-2xl">

        {/*    Flex container inside card*/}
        <div className="flex flex-col rounded-l-xl">

            {/*    Image*/}
            <img
                src={mothAndFern}
                alt="Ellie's Tattoo"
                className="object-fit rounded-l-xl rounded-r-xl h-80 transform"
            />

            {/* Content*/}
            <div className="p-6">
                <h2 className="text-2xl font-bold text-center text-[#2A2D2A]">Checkpoint Title</h2>
                <p className="max-w-xs my-1 text-s font-medium leading-5 tracking-wide text-center text-[#2A2D2A]">Checkpoint Description</p>
                <p className="max-w-xs my-2 mt-6 text-xl leading-5 tracking-wide text-center text-[#E7E3DA]">Checkpoint Question</p>

            </div>

        </div>

    </div>


    )
}

export default FormCheckpointCard;