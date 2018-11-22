import React, {Component} from 'react';
import PropTypes from "prop-types";
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Button from '@material-ui/core/Button';

export class GMTable extends Component {

    // constructor(props) {
    //     super(props);
    // }

    componentDidMount () {

    }

    componentDidUpdate (prevProps, prevState, snapshot) {
    }

    getColumns () {
        const {children} = this.props;
        return <TableHead>
            <TableRow>
                {children}
            </TableRow>
        </TableHead>;
    }

    getActions (data) {
        if (data._actions && data._actions.length > 0) {
            return data._actions.map((d, i) => {
                return <TableCell key={'delete_right_' + i}>
                    <Button onClick={d.action(data.id)}>{d.name}</Button>
                </TableCell>
            })
        }

        return null;
    }

    getRows () {
        let {data} = this.props;
        let cells = data.map(d => {
            return (
                <TableRow key={d.id} hover onClick={this.rowSelect(d.id)}>
                    <TableCell>{d.code}</TableCell>
                    <TableCell>{d.name}</TableCell>
                    <TableCell>{d.description}</TableCell>
                    <TableCell>{d.api}</TableCell>
                    {this.getActions(d)}
                </TableRow>
            );
        });

        return data.length === 0 ? null : <TableBody>{cells}</TableBody>;
    }

    rowSelect = (id) => (e) => {
        let {onRowSelect} = this.props;
        if (onRowSelect) {
            onRowSelect.call(this, id);
        }
    };

    render () {
        return <Table>
            {this.getColumns()}
            {this.getRows()}
        </Table>;
    }
}

GMTable.propTypes = {
    data: PropTypes.array,
    onRowSelect: PropTypes.func
};

GMTable.defaultValues = {
    data: [],
    onRowSelect: null
};

