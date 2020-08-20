var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var Home = function (_React$Component) {
    _inherits(Home, _React$Component);

    function Home(props) {
        _classCallCheck(this, Home);

        return _possibleConstructorReturn(this, (Home.__proto__ || Object.getPrototypeOf(Home)).call(this, props));
    }

    _createClass(Home, [{
        key: "render",
        value: function render() {
            return React.createElement(
                "nav",
                { "class": "navbar navbar-expand-lg navbar-dark bg-primary" },
                React.createElement(
                    "a",
                    { "class": "navbar-brand", href: "#" },
                    "Navbar"
                ),
                React.createElement(
                    "button",
                    { "class": "navbar-toggler", type: "button", "data-toggle": "collapse", "data-target": "#navbarColor01", "aria-controls": "navbarColor01", "aria-expanded": "false", "aria-label": "Toggle navigation" },
                    React.createElement("span", { "class": "navbar-toggler-icon" })
                ),
                React.createElement(
                    "div",
                    { "class": "collapse navbar-collapse", id: "navbarColor01" },
                    React.createElement(
                        "ul",
                        { "class": "navbar-nav mr-auto" },
                        React.createElement(
                            "li",
                            { "class": "nav  -item active" },
                            React.createElement(
                                "a",
                                { "class": "nav-link", href: "#" },
                                "Home ",
                                React.createElement(
                                    "span",
                                    { "class": "sr-only" },
                                    "(current)"
                                )
                            )
                        ),
                        React.createElement(
                            "li",
                            { "class": "nav-item" },
                            React.createElement(
                                "a",
                                { "class": "nav-link", href: "#" },
                                "Neutron"
                            )
                        ),
                        React.createElement(
                            "li",
                            { "class": "nav-item" },
                            React.createElement(
                                "a",
                                { "class": "nav-link", href: "#" },
                                "Games"
                            )
                        ),
                        React.createElement(
                            "li",
                            { "class": "nav-item" },
                            React.createElement(
                                "a",
                                { "class": "nav-link", href: "#" },
                                "About"
                            )
                        ),
                        React.createElement(
                            "li",
                            { "class": "nav-item" },
                            React.createElement(
                                "a",
                                { "class": "nav-link", href: "#" },
                                "Profile"
                            )
                        )
                    ),
                    React.createElement(
                        "form",
                        { "class": "form-inline my-2 my-lg-0" },
                        React.createElement("input", { "class": "form-control mr-sm-2", type: "text", placeholder: "Search" }),
                        React.createElement(
                            "button",
                            { "class": "btn btn-secondary my-2 my-sm-0", type: "submit" },
                            "Search"
                        )
                    )
                )
            );
        }
    }]);

    return Home;
}(React.Component);

ReactDOM.render(React.createElement(Home, null), document.getElementById('root'));