import { connect } from "react-redux";

const mapStateToProps = state => ({
    rights: state.rights
});

export const withRights = connect(mapStateToProps);