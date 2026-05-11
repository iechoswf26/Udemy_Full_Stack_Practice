import {Routes, Route} from "react-router-dom";
import Posts from "../pages/Posts.jsx";
import LandingPage from "../pages/LandingPage.jsx"
import Chapter from "../pages/Chapter.jsx";
import Account from "../pages/Account.jsx"

export default function AppRoutes () {
    return (
        <Routes>
            <Route path={"/"} element={<LandingPage/>}/>
            <Route path ={"/Chapters"} element={<Chapter/>}/>
            <Route path ={"/Posts"} element={<Posts/>}/>
            <Route path={"/Account"} element={<Account/>}/>

        </Routes>
    )
}