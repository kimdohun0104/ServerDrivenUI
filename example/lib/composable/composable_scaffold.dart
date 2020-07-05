import 'package:dynamic_ui/composable/composable.dart';
import 'package:flutter/material.dart';

class ComposableScaffold extends StatelessWidget {
  final List<Map<String, dynamic>> composerInfoMaps;
  final Map<String, Composable> composerByName;

  ComposableScaffold({this.composerInfoMaps, this.composerByName});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
          children: composerInfoMaps
              .map((widget) =>
                  composerByName[widget['type']].compose(widget, context))
              .toList()),
    );
  }
}