import React from "react"
import { Route, BrowserRouter } from "react-router-dom"
import NavBar from "./NavBar"

const App = props => {
  return (
    <BrowserRouter>
      <Route path="/" component={NavBar} />
    </BrowserRouter>
  )
}

export default App
