//
//  index.js
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

import { NativeModules } from 'react-native';
import NodePlayer from './NodePlayer';
import NodePublisher from './NodePublisher';

const NodeMediaClient = NativeModules.NodeMediaClient;
export { NodeMediaClient, NodePlayer, NodePublisher };