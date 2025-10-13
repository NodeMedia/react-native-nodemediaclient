//
//  RCTNodePlayerView.h
//
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <React/RCTView.h>

@interface RCTNodePlayerView : UIView

@property (strong, nonatomic) NSString *url;

@property (strong, nonatomic) NSString *cryptoKey;

@property (strong, nonatomic) NSString *HTTPReferer;

@property (strong, nonatomic) NSString *HTTPUserAgent;

@property (nonatomic) int bufferTime;

@property (nonatomic) int scaleMode;

@property (nonatomic) BOOL autoplay;

@property (nonatomic) BOOL HWAccelEnable;

@property (nonatomic) float volume;

@property (nonatomic, copy) RCTBubblingEventBlock onChange;

-(int)start;

-(int)stop;

@end
