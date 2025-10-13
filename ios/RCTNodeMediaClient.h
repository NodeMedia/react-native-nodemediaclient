//
//  RCTNodeMediaClient.h
//
//
//  Created by Mingliang Chen on 2018/2/28.
//  Copyright © 2018-2024年 Mingliang Chen. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>
@interface RCTNodeMediaClient : NSObject<RCTBridgeModule>

@property (class, nonatomic, copy) NSString *license;

@end
