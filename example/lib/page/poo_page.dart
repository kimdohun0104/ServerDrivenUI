import 'package:dynamic_ui/composable/composable_scaffold.dart';
import 'package:dynamic_ui/composable/composable.dart';
import 'package:flutter/material.dart';

class PooPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ComposableScaffold(
      composerByName: {
        'PooAppBar': PooAppBarComposer(),
        'PooList': PooList(),
      },
      composerInfoMaps: [
        {
          'type': 'PooAppBar',
          'content': {
            'title': 'Poo',
            'subTitle': 'Hello Poo',
          }
        },
        {
          'type': 'PooList',
          'content': {
            'items': [
              {
                'name': '김도훈',
                'description': '플러터를 개발한다',
              },
              {
                'name': '김도훈입니다',
                'description': '이것은 Server Driven UI!!',
              }
            ]
          }
        }
      ],
    );
  }
}

class PooAppBarComposer implements Composable {
  @override
  Widget compose(Map<String, dynamic> map, BuildContext context) {
    final String title = map['content']['title'];
    final String subTitle = map['content']['subTitle'];

    return AppBar(
      title: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            title,
            style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
          ),
          Text(
            subTitle,
            style: TextStyle(fontSize: 16),
          )
        ],
      ),
    );
  }
}

class PooList implements Composable {
  @override
  Widget compose(Map<String, dynamic> map, BuildContext context) {
    final Iterable itemIterable = map['content']['items'];
    final List<PooItem> items =
        itemIterable.map((e) => PooItem.fromMap(e)).toList();

    return Expanded(
      child: ListView.builder(
        padding: EdgeInsets.all(24),
        itemBuilder: (context, index) {
          PooItem item = items[index];
          return Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                item.name,
                style: TextStyle(
                  fontSize: 20,
                  color: Colors.blue,
                  fontWeight: FontWeight.bold,
                ),
              ),
              SizedBox(height: 4),
              Text(
                item.description,
                style: TextStyle(fontSize: 14),
              ),
              SizedBox(height: 20),
            ],
          );
        },
        itemCount: items.length,
      ),
    );
  }
}

class PooItem {
  final String name;
  final String description;

  PooItem({this.name, this.description});

  factory PooItem.fromMap(Map<String, dynamic> from) {
    return PooItem(
      name: from['name'],
      description: from['description'],
    );
  }
}
