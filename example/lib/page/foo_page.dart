import 'package:dynamic_ui/composable/composable_scaffold.dart';
import 'package:flutter/material.dart';
import 'package:dynamic_ui/composable/composable.dart';

class FooPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ComposableScaffold(
      composerByName: {
        'FooAppBar': FooAppBarComposer(),
        'FooButton': FooButtonComposer(),
      },
      composerInfoMaps: [
        {
          'type': 'FooAppBar',
          'content': {
            'title': 'Foo',
          },
        },
        {
          'type': 'FooButton',
          'content': {
            'text': 'Go to Poo!',
          },
          'action': {
            'onPress': {
              'case': 'navigation',
              'data': {
                'route': '/poo',
              }
            }
          }
        },
      ],
    );
  }
}

class FooAppBarComposer implements Composable {
  @override
  Widget compose(Map<String, dynamic> map, BuildContext context) {
    final String title = map['content']['title'];

    return AppBar(
      title: Text(title),
    );
  }
}

class FooButtonComposer implements Composable {
  @override
  Widget compose(Map<String, dynamic> map, BuildContext context) {
    final String text = map['content']['text'];
    final String route = map['action']['onPress']['data']['route'];

    return RaisedButton(
      onPressed: () {
        Navigator.pushNamed(context, route);
      },
      child: Text(text),
    );
  }
}
