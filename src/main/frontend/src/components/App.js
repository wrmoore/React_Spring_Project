import React from "react"
import { Route, BrowserRouter, Redirect } from "react-router-dom"
import NavBar from "./NavBar"

const App = props => {
  return (
  		<BrowserRouter>
          <Route exact path="/">
            <Redirect to="/pets"/>
          </Route>
          <Route path="/pets" component={NavBar} />
          <Route path="/adoptions" component={NavBar} />
        </BrowserRouter>
  )
}

export default App
